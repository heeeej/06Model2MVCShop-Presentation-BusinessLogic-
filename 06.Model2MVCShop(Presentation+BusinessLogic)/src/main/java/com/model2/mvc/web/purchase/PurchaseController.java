package com.model2.mvc.web.purchase;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;




@Controller
public class PurchaseController {
	
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Value("#{commonProperties['pageUnit']}")
	//@Value("#{commonProperties['pageUnit'] ?: 3}")
	int pageUnit;
	
	@Value("#{commonProperties['pageSize']}")
	//@Value("#{commonProperties['pageSize'] ?: 2}")
	int pageSize;
	

	public PurchaseController() { 
		System.out.println("==>ProductController default Constructor call.............");
	}
	
	@RequestMapping("/addPurchaseView.do")
	public String addPurchaseViewAction(@ModelAttribute("purchase") Purchase purchase,
																							@RequestParam("prodNo") int prodNo,
																							Model model) 
																																							throws Exception{
		System.out.println("\n::::::: addPurchase() ==> forward:/addPurchaseView.jsp ");
		
		Product product = productService.getProduct(prodNo);
		purchase.setPurchaseProd(product);
		
		model.addAttribute("purchase", purchase);
		
		return "forward:/purchase/addPurchaseView.jsp";
	}
	
	
	@RequestMapping("/addPurchase.do")
	public String addPurchaseAction(@ModelAttribute("purchase") Purchase purchase,
																				@ModelAttribute("user") User user,
																				@ModelAttribute("product") Product product,
																				HttpServletRequest request,
																				Model model)
																														throws Exception{
		
		System.out.println("\n:: ==> addPurchase() start....");
		
		user.setUserId(request.getParameter("userId"));
		purchase.setBuyer(user);
		
		System.out.println("::::buyerId 확인 ==>>> "+ purchase.getBuyer().getUserId());
		
		purchase.setPurchaseProd(product);
		purchaseService.addPurchase(purchase);
		
		System.out.println("::::purchase 구매확인 ==>>> "+ purchase);
	
		model.addAttribute("purchase", purchase);
		
		System.out.println("[addPurchase() end.......]\n");
		
		return "/purchase/addPurchase.jsp";
	}
		
	
	@RequestMapping("/getPurchase.do")
	public String getPurchase1Action(@ModelAttribute("purchase") Purchase purchase,
																	Model model)
																									throws Exception{
		
		System.out.println("\n:: ==> getProduct() start....");
		
		int tranNo = purchase.getTranNo();
		
		System.out.println(":: getTranNo 확인==>  "+purchase.getTranNo());
		
		purchase = purchaseService.getPurchase(tranNo);
		
		System.out.println(":: getPurchase 확인==>  "+purchase);
		
		model.addAttribute("purchase",purchase);
		
		System.out.println("[getProduct() end.......]\n");
		
		return "forward:/purchase/getPurchase.jsp";
		
	}
	
	@RequestMapping("/getPurchase2.do")
	public String getPurchase2Action(@ModelAttribute("purchase") Purchase purchase,
																	Model model)
																									throws Exception{
		
		System.out.println("\n:: ==> getProduct() start....");
		
		int prodNo = purchase.getPurchaseProd().getProdNo();
		
		System.out.println(":: getProdNo 확인==>  "+prodNo);
		
		purchase = purchaseService.getPurchase(prodNo);
		
		System.out.println(":: getPurchase 확인==>  "+purchase);
		
		model.addAttribute("purchase",purchase);
		
		System.out.println("[getProduct() end.......]\n");
		
		return "forward:/purchase/getPurchase.jsp";
		
	}
	
	@RequestMapping("/listPurchase.do")
	public String listPurchaseAction(@ModelAttribute("search") Search search,
																				@ModelAttribute("purchase") Purchase purchase,
																				 HttpServletRequest request,
																				 Model model) 
																														throws Exception {
		
		System.out.println("\n:: ==> ListPurchase() start....");
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		User user =(User)request.getSession().getAttribute("user");
		purchase.setBuyer(user);
		 
		System.out.println(":::CurrentPage 확인===>>>  "+search.getCurrentPage());
		System.out.println(":::buyerId 확인 ===>>> "+purchase.getBuyer().getUserId());	
		
		// Business logic 수행
		Map<String , Object> map=purchaseService.getPurchaseList(search, purchase.getBuyer().getUserId());
		
		System.out.println(":::buyerId 확인 ===>>> "+purchase.getBuyer().getUserId());
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		// Model 과 View 연결
		
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);		

		System.out.println("\n:: ==> ListPurchase() end....");
		
		return "/purchase/listPurchase.jsp";
		
	}
	
	@RequestMapping("/listSale.do")
	public String salePurchaseAction(@ModelAttribute("search") Search search, Model model)
																														throws Exception {
		
		System.out.println("\n:: ==> ListSale() start....");
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		System.out.println("::CurrentPage 확인==>  "+search.getCurrentPage());
		
		// Business logic 수행
		Map<String , Object> map=purchaseService.getSaleList(search);
		
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		// Model 과 View 연결
		
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);		
		
		
		System.out.println("\n:: ==> ListPurchase() end....");
		
		return "/purchase/listSalePurchase.jsp";
		
	}	
	
	@RequestMapping("/updatePurchaseView.do")
	public String updatePurchaseViewAction(@RequestParam("tranNo") int tranNo,
																								@ModelAttribute("purchase") Purchase purchase,
																								Model model)
																														throws Exception {
		System.out.println("\n:: ==> updatePurchaseView() start....");
		
		purchase = purchaseService.getPurchase(tranNo);
		purchase.setDlvyDate(purchase.getDlvyDate().substring(0,10).replace("-",""));
		
		// Model 과 View 연결
		model.addAttribute("purchase", purchase);
		
			
		System.out.println("\n:: ==> updatePurchase() end....");
		
		return "/purchase/updatePurchaseView.jsp";
		
	}
	
	
	@RequestMapping("/updatePurchase.do")
	public String updatePurchaseAction(@ModelAttribute("purchase") Purchase purchase, Model model) 
																														throws Exception {
		System.out.println("\n:: ==> updatePurchase() start....");
		
		purchaseService.updatePurchase(purchase);
		
		// Model 과 View 연결
		model.addAttribute("purchase", purchase);

		System.out.println("\n:: ==> updatePurchase() end....");
		
		return "forward:/getPurchase.do";
		
	}
	
	@RequestMapping("/updateTranCode.do")
	public String updateTranCodeAction(@RequestParam("tranNo") int tranNo,
																						@RequestParam("tranCode") String tranCode,
																						Model model) 
																														throws Exception {
		System.out.println("\n:: ==> updateTranCode() start....");
		
		Purchase purchase = purchaseService.getPurchase(tranNo);
		purchase.setTransCode(tranCode);
		purchaseService.updateTranCode(purchase);
		
		// Model 과 View 연결
		model.addAttribute("purchase", purchase);
					
		System.out.println("\n:: ==> updateTranCode() end....");
		
		return "forward:/listPurchase.do";
	}

	@RequestMapping("/updateTranCodeByProd.do")
	public String updateTranCodeByProdAction(@RequestParam("prodNo") int prodNo,
																									@RequestParam("tranCode") String tranCode,
																									Model model) 
																														throws Exception {
		System.out.println("\n:: ==> updateTranCodeByProd() start....");
		
		Purchase purchase = purchaseService.getPurchase2(prodNo);

		purchase.setTransCode(tranCode);
		purchaseService.updateTranCode(purchase);

		// Model 과 View 연결
		model.addAttribute("purchase", purchase);
					
		System.out.println("\n:: ==> updateTranCodeByProd() end....");
		
		return "forward:/listProduct.do";
	}
	
}
