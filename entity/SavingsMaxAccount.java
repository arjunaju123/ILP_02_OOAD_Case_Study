package com.ilp.entity;
import java.util.ArrayList;
//SavingsMaxAccount is a Product(minimumBalance of Rs1000 should be maintained in the
//account)-include a variable minimumBalance
public class SavingsMaxAccount extends Product {	
	private Double minimumBalance = 1000.0;
	public SavingsMaxAccount(String productCode, String productName, ArrayList<Service> serviceList) {
		super(productCode, productName, serviceList);
		//this.minimumBalance = minimumBalance;
	}
	public Double getMinimumBalance() {
		return minimumBalance;
	}
	public void setMinimumBalance(Double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}	
}
