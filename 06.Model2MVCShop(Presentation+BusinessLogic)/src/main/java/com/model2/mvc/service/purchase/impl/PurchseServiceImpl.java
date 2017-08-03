package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDao;
import com.model2.mvc.service.purchase.PurchaseService;

@Service("purchaseServiceImpl")
public class PurchseServiceImpl implements PurchaseService {

		@Autowired
		@Qualifier("purchaseDaoImpl")
		PurchaseDao purchaseDao;
	
	public PurchseServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void setPurchaseDao(PurchaseDao purchaseDao){
		System.out.println("::"+getClass()+".setPurchaseDao Call......");
		this.purchaseDao = purchaseDao;
	}	

	public int addPurchase(Purchase purchase) throws Exception{
		return purchaseDao.addPurchase(purchase);
	}
	
	public Purchase getPurchase(int tranNo) throws Exception{
		return purchaseDao.getPurchase(tranNo);
	}
	
	public Purchase getPurchase2(int prodNo) throws Exception{
		return purchaseDao.getPurchase2(prodNo);
	}
	
	public Map<String,Object> getPurchaseList(Search search, String buyerId) throws Exception{
		
		List<Purchase> list= purchaseDao.getPurchaseList(search, buyerId);
		int totalCount = purchaseDao.getPurchaseTotalCount(search, buyerId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
	
		
		return map;
	}
	
	public Map<String,Object> getSaleList(Search search) throws Exception{
		
		List<Purchase> list= purchaseDao.getSaleList(search);
		int totalCount = purchaseDao.getSaleTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}
	
	public int updatePurchase(Purchase purchase) throws Exception{
		return purchaseDao.updatePurchase(purchase);
	}
	
	public int updateTranCode(Purchase purchase) throws Exception{
		return purchaseDao.updateTranCode(purchase);
	}
	
}
