package com.ilp.entity;
//Account(accountNo,accountType,balance,Product).
public class Account {//account has a product
		private static final double MIN_BALANCE = 1000;
		private String accountNo;
		private String accountType;
		private double balance;
		private Product product;		
		public String getAccountNo() {
			return accountNo;
		}
		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public Double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		@Override
		public String toString() {
			return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", balance=" + balance
					+ ", product=" + product + "]";
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public Account(String accountNo, String accountType, double balance, Product product) {
			super();
			this.accountNo = accountNo;
			this.accountType = accountType;
			this.balance = balance;
			this.product = product;
		}
		public void deposit(double depositAmount) {
	        if (depositAmount > 0) {
	            balance += depositAmount;
	            System.out.println("Deposit successful. New balance: " + balance);
	        } else {
	            System.out.println("Invalid deposit amount. Please enter a positive value.");
	        }
	    }
	    public boolean withdraw(double withdrawAmount) {
	        if (withdrawAmount > 0 && (balance - withdrawAmount) >= MIN_BALANCE) {
	            balance -= withdrawAmount;
	            System.out.println("Withdrawal successful. New balance: " + balance);
	            return true;
	        } else {
	            System.out.println("Withdrawal failed. Insufficient funds or invalid withdrawal amount.");
	            return false;
	        }
	    }
}
