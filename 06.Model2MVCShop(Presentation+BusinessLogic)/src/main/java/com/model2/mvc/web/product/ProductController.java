package com.model2.mvc.web.product;

import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;


@Controller
public class ProductController {
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Value("#{commonProperties['pageUnit']}")
	//@Value("#{commonProperties['pageUnit'] ?: 3}")
	int pageUnit;
	
	@Value("#{commonProperties['pageSize']}")
	//@Value("#{commonProperties['pageSize'] ?: 2}")
	int pageSize;
	

	public ProductController() { 
		System.out.println("==>ProductController default Constructor call.............");
	}
	
	@RequestMapping("/addProduct.do")
	public ModelAndView addProductAction(@ModelAttribute("product") Product product)
																														throws Exception{
		
		System.out.println("\n:: ==> addProduct() start....");
		
		ModelAndView modelAndView = new ModelAndView();
		
		productService.addProduct(product);
		
		
		
		modelAndView.setViewName("/product/addProduct.jsp");
		modelAndView.addObject("product", product);
		
		System.out.println("[addProduct() end.......]\n");
		
		return modelAndView;
	}
		
	
	@RequestMapping("/getProduct.do")
	public ModelAndView getProductAction(@ModelAttribute("product") Product product,
																	@RequestParam("menu") String menu)
																		throws Exception{
		
		System.out.println("\n:: ==> getProduct() start....");
		
		int prodNo = product.getProdNo();
		
		System.out.println(":: getProdNo 확인==>  "+product.getProdNo());
		
		product = productService.getProduct(prodNo);
		
		System.out.println(":: getProduct 확인==>  "+product);
		
		String viewPage = "";
		
		if (menu.equals("manage")) {
			viewPage=  "forward:/product/updateProductView.jsp";
		} else{
			viewPage= "forward:/product/getProductList.jsp";
		}
		
		System.out.println(":: Navigation Page 확인==>  "+viewPage);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewPage);
		modelAndView.addObject("product",product);
		
		System.out.println("[getProduct() end.......]\n");
		
		return modelAndView;
		
	}
	
	@RequestMapping("/listProduct.do")
	public ModelAndView listProductAction(@ModelAttribute("search") Search search) 
																														throws Exception {
		
		System.out.println("\n:: ==> ListProduct() start....");
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		System.out.println("::CurrentPage 확인==>  "+search.getCurrentPage());
		
		// Business logic 수행
		Map<String , Object> map=productService.getProductList(search);
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		// Model 과 View 연결
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", map.get("list"));
		modelAndView.addObject("resultPage", resultPage);
		modelAndView.addObject("search", search);		
		modelAndView.setViewName("/product/listProduct.jsp");
		
		System.out.println("\n:: ==> ListProduct() end....");
		
		return modelAndView;
		
	}
	
	
	@RequestMapping("/updateProduct.do")
	public ModelAndView updateProductAction(@ModelAttribute("product") Product product) 
																														throws Exception {
		System.out.println("\n:: ==> updateProduct() start....");
		
		productService.updateProduct(product);
		
		// Model 과 View 연결
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("product", product);
		modelAndView.setViewName("/product/updateProduct.jsp");
		
		System.out.println("::updateProduct- regDate 확인 ==>>>> "+product);
		
		System.out.println("\n:: ==> updateProduct() end....");
		
		return modelAndView;
		
	}

}
