package com.model2.mvc.service.domain;

import java.util.Date;

public class Purchase {
 
	private User buyer;          //user ����
	private String dlvyAddr; //������ּ�
	private String dlvyDate;	//����������
	private String dlvyRequest;		//��۽� �䱸����
	private Date orderDate;		//��������
	private String paymentOption;		//���ҹ��
	private Product purchaseProd;		//product ���Ź�ǰ����
	private String receiverName;		//�޴»�� �̸�
	private  String receiverPhone;		//�޴»�� ��ȭ��ȣ
	private String transCode;				//���Ż����ڵ�
	private int tranNo;			//���Ź�ȣ
	
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
