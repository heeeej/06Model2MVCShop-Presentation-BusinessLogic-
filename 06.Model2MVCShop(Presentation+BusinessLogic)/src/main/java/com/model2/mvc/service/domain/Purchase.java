package com.model2.mvc.service.domain;

import java.util.Date;

public class Purchase {
 
	private User buyer;          //user 정보
	private String dlvyAddr; //배송지주소
	private String dlvyDate;	//배송희망일자
	private String dlvyRequest;		//배송시 요구사항
	private Date orderDate;		//구매일자
	private String paymentOption;		//지불방식
	private Product purchaseProd;		//product 구매물품정보
	private String receiverName;		//받는사람 이름
	private  String receiverPhone;		//받는사람 전화번호
	private String transCode;				//구매상태코드
	private int tranNo;			//구매번호
	
	public Purchase(){
	}
	
	public Purchase(User buyer, String dlvyAddr, String dlvyDate, String dlvyRequest, String paymentOption,
			Product purchaseProd, String receiverName, String receiverPhone) {
	
		this.buyer = buyer;
		this.dlvyAddr = dlvyAddr;
		this.dlvyDate = dlvyDate;
		this.dlvyRequest = dlvyRequest;
		this.paymentOption = paymentOption;
		this.purchaseProd = purchaseProd;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public String getDlvyAddr() {
		return dlvyAddr;
	}

	public void setDlvyAddr(String dlvyAddr) {
		this.dlvyAddr = dlvyAddr;
	}

	public String getDlvyDate() {
		return dlvyDate;
	}

	public void setDlvyDate(String dlvyDate) {
		this.dlvyDate = dlvyDate;
	}

	public String getDlvyRequest() {
		return dlvyRequest;
	}

	public void setDlvyRequest(String dlvyRequest) {
		this.dlvyRequest = dlvyRequest;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public Product getPurchaseProd() {
		return purchaseProd;
	}

	public void setPurchaseProd(Product purchaseProd) {
		this.purchaseProd = purchaseProd;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String recieverPhone) {
		this.receiverPhone = recieverPhone;
	}

	public String getTransCode() {
		return transCode;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public int getTranNo() {
		return tranNo;
	}

	public void setTranNo(int tranNo) {
		this.tranNo = tranNo;
	}

	@Override
	public String toString() {
		return "Purchase [buyer=" + buyer + ", dlvyAddr=" + dlvyAddr + ", dlvyDate=" + dlvyDate + ", dlvyRequest="
				+ dlvyRequest + ", orderDate=" + orderDate + ", paymentOption=" + paymentOption + ", purchaseProd="
				+ purchaseProd + ", receiverName=" + receiverName + ", receiverPhone=" + receiverPhone + ", transCode="
				+ transCode + ", tranNo=" + tranNo + "]";
	}
	
	
	
	
}
