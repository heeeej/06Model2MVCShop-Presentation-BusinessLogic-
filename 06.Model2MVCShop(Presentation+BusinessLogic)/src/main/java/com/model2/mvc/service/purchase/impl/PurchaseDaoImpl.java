package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDao;




@Repository("purchaseDaoImpl")
public class PurchaseDaoImpl implements PurchaseDao {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public PurchaseDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSqlSession(SqlSession sqlSession){
		System.out.println("::"+getClass()+".setSqlSession() call...........");
		this.sqlSession = sqlSession;
	}
	
	public int addPurchase(Purchase purchase) throws Exception{
		return sqlSession.insert("PurchaseMapper.addPurchase",purchase);
	}
	
	public Purchase getPurchase(int tranNo) throws Exception{
		return sqlSession.selectOne("PurchaseMapper.getPurchase",tranNo);
	}
	
	public Purchase getPurchase2(int prodNo) throws Exception{
		return sqlSession.selectOne("PurchaseMapper.getPurchase2",prodNo);
	}
	
	public List<Purchase> getPurchaseList(Search search,String buyerId) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("search", search);
		map.put("buyerId", buyerId);
		
		return sqlSession.selectList("PurchaseMapper.getPurchaseList",map);
	}
	
	public List<Purchase> getSaleList(Search search) throws Exception{
		return sqlSession.selectList("PurchaseMapper.getSaleList",search);
	}
	
	public int updatePurchase(Purchase purchase) throws Exception{
		return sqlSession.update("PurchaseMapper.updatePurchase",purchase);
	}
	
	public int updateTranCode(Purchase purchase) throws Exception{
		
		return sqlSession.update("PurchaseMapper.updateTranCode",purchase);
	}
	
	public int getPurchaseTotalCount(Search search,String buyerId) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("search", search);
		map.put("buyerId", buyerId);
			
		return sqlSession.selectOne("PurchaseMapper.getPurchaseTotalCount", map);
	}
	
	public int getSaleTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("PurchaseMapper.getSaleTotalCount", search);
	}
	
	
}
