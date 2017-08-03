package com.model2.mvc.service.product.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDao;




@Repository("productDaoImpl")
public class ProductDaoImpl implements ProductDao {

		@Autowired
		@Qualifier("sqlSessionTemplate")
		private SqlSession sqlSession;
	
	
	public ProductDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public void setSqlSession(SqlSession sqlSession){
		System.out.println("::"+getClass()+".setSqlSession() call...........");
		this.sqlSession = sqlSession;
	}
	
	public int addProduct(Product product) throws Exception{
		
		product.setManuDate(product.getManuDate().replace("-", ""));
	
		return sqlSession.insert("ProductMapper.addProduct",product);
	}
	
	public Product getProduct(int prodNo) throws Exception{
		return sqlSession.selectOne("ProductMapper.getProduct",prodNo);
	}
	
	public int updateProduct(Product product) throws Exception{
		
		product.setManuDate(product.getManuDate().replace("-", ""));
		return sqlSession.update("ProductMapper.updateProduct",product);
	}


	public List<Product> getProductList(Search search) throws Exception{
		return sqlSession.selectList("ProductMapper.getProductList",search);
	}
	
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("ProductMapper.getTotalCount", search);
	}

}
