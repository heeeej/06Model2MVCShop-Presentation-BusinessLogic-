package com.model2.mvc.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDao;
import com.model2.mvc.service.product.ProductService;



@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
		
		@Autowired
		@Qualifier("productDaoImpl")
		ProductDao productDao;
		
	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void setProductDao(ProductDao productDao){
		System.out.println("::"+getClass()+".setProductDao Call......");
		this.productDao = productDao;
	}
	
	public int addProduct(Product product) throws Exception{
		return productDao.addProduct(product);
	}
	
	public Product getProduct(int prodNo) throws Exception{
		return productDao.getProduct(prodNo);
	}
	
	public int updateProduct(Product product) throws Exception{
		return productDao.updateProduct(product);
	}
	
	public Map<String, Object> getProductList(Search search) throws Exception{
		List<Product> list= productDao.getProductList(search);
		int totalCount = productDao.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}
	
	

}