// com.ilp.service.BankService.java
//[Create all the services in Create Service option and attach the created services 
//to their respective products in Create Product option ]
package com.ilp.services;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import com.ilp.entity.Account;
import com.ilp.entity.CurrentAccount;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class BankService {
	public static void createService(ArrayList<Service> serviceList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter service code:");
		String serviceCode = scanner.nextLine();
		System.out.println("Enter service name:");
		String serviceName = scanner.nextLine();
		System.out.println("Enter service rate:");
		double rate = scanner.nextDouble();
		Service newService = new Service(serviceCode, serviceName, rate);
		serviceList.add(newService);
		System.out.println("Service created successfully!");
	}
	public static void createProduct(ArrayList<Service> serviceList, ArrayList<Product> productList) {
		ArrayList<Service> productServiceList = new ArrayList<Service>();
		Product newProduct = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter product code:");
		String productCode = scanner.nextLine();
		System.out.println("Enter product name:");
		String productName = scanner.nextLine();
		System.out.println("AVAILABLE SERVICES ARE ");
		for (Service service : serviceList) {
			System.out.println("Service Code: " + service.getServiceCode());
		}
		System.out.println("Enter the service needed for product from service list above");
		String serviceCode = scanner.nextLine();
		for (Service service : serviceList) {
			if (service.getServiceCode().equals(serviceCode)) {
				productServiceList.add(service);
			}
		}
		System.out.println("enter the products needed ");
		System.out.println(" 1. loan account, 2. savings max account, 3. current account");
		// Product newProduct;
		int mainChoice = scanner.nextInt();
		switch (mainChoice) {
		case 1: 
			newProduct = new LoanAccount(productCode, productName, serviceList);
			productList.add(newProduct);
			System.out.println("Product created successfully!");
			break;
		case 2: 
			newProduct = new SavingsMaxAccount(productCode, productName, serviceList);
			productList.add(newProduct);
			System.out.println("Product created successfully!");
			break;
		case 3: 
			newProduct = new CurrentAccount(productCode, productName, serviceList);
			productList.add(newProduct);
			System.out.println("Product created successfully!");
			break;
		}
	}
	ArrayList<Account> accountList = null;
	static ArrayList<Customer> customerList = new ArrayList<>();;

	public static void createCustomer(ArrayList<Account> accountList, ArrayList<Product> productList,ArrayList<Customer> customerList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter customer code:");
		String customerCode = scanner.nextLine();
		System.out.println("Enter customer name:");
		String customerName = scanner.nextLine();
		System.out.println("Enter account type:");
		String accountType = scanner.nextLine();

		Random random = new Random();
		// Generate a random decimal between 0 and 10
		double accountNo = random.nextInt() * 10;

		String accountNum = Double.toString(accountNo);
		System.out.println("Account number: " + accountNo);
		System.out.println("enter balance to add ");

		double balance = scanner.nextInt();
		System.out.println("product list is ");
		int i = 1;
		for (Product productService : productList) {
			System.out.println(i + " :Product list: " + productService.getProductName());
			i++;
		}
		System.out.println("1. savings max account 2.loan account 3. current account");
		System.out.println("enter product number to add from above list");
		Product productService = null;
		int mainChoice = scanner.nextInt();
		switch (mainChoice) {
		case 1: {
			for (Product product : productList) {
				if ("Savingsmax".equals(product.getProductName())) {
					productService = product;
				}}
			break; // Add break to exit the switch after each case
		}
		case 2: {
			for (Product product : productList) {
				if ("Loan".equals(product.getProductName())) {
					productService = product;
				}}
			break;
		}
		case 3: {
			for (Product product : productList) {
				if ("Current".equals(product.getProductName())) {
					productService = product;
				}}
			break;
		}}
		// Create a new ArrayList<Account> for each customer
		ArrayList<Account> newAccountList = new ArrayList<>();
		Account account = new Account(accountNum, productService.getProductName(), balance, productService);
		newAccountList.add(account);
		Customer customer = new Customer(customerCode, customerName, newAccountList);
		accountList.add(account);
		customerList.add(customer);
		for (Customer customerService : customerList) {
			System.out.println("customer list issss : " + customerService.toString());
		}
		System.out.println("Customer created successfully!");
	}

	public static void manageAccounts(ArrayList<Customer> customerList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the customer code:");
		String customerCode = scanner.nextLine().trim();

		for (Customer customer : customerList) {
			if (customer.getCustomerCode().equalsIgnoreCase(customerCode)) {
				System.out.println("Customer Name: " + customer.getCustomerName());
				System.out.println("Customer Code: " + customerCode);
				System.out.println("Account Details:");
				ArrayList<Account> accountList = customer.getAccountList();
				displayAccountDetails(accountList);
				System.out.println("Choose an account to manage:");
				int accountChoice = scanner.nextInt();
				Account selectedAccount = accountList.get(accountChoice - 1);
				manageAccountOperations(selectedAccount);
				return;
			}
		}
		System.out.println("Customer with code " + customerCode + " not found.");
	}
	private static void displayAccountDetails(ArrayList<Account> accountList) {
		System.out.println("*************************Customer-Account Details****************");
		System.out.printf("%-10s %-15s %-20s %-10s%n", "AccountNo", "CustomerId", "AccountType", "Balance");

		for (int i = 0; i < accountList.size(); i++) {
			Account account = accountList.get(i);
			System.out.printf("%-10d %-15s %-20s %-10.2f%n", i + 1, account.getAccountNo(), account.getAccountType(),
					account.getBalance());
		}
		System.out.println("************************************************************");
	}

	private static void manageAccountOperations(Account account) {
		Scanner scanner = new Scanner(System.in);
		char continueChoice;
		do {
			System.out.println("1. Deposit 2. Withdraw 3. Display Balance");
			System.out.print("Enter your choice: ");
			int operationChoice = scanner.nextInt();
			switch (operationChoice) {
			case 1:
				System.out.print("Enter the amount to be deposited: ");
				double depositAmount = scanner.nextDouble();
				account.deposit(depositAmount);
				System.out.println("Your current balance is: " + account.getBalance());
				break;
			case 2:
				System.out.print("Enter the amount to be withdrawn: ");
				double withdrawAmount = scanner.nextDouble();
				boolean success = account.withdraw(withdrawAmount);
				if (success) {
					System.out.println("Your current balance is: " + account.getBalance());
				} else {
					System.out.println("No minimum balance of 1000 present ");
				}
				break;
			case 3:
				System.out.println("Your current balance is: " + account.getBalance());
				break;
			default:
				System.out.println("Invalid choice.");
			}

			System.out.print("Do you want to continue (Y/N): ");
			continueChoice = scanner.next().charAt(0);
		} while (continueChoice == 'Y' || continueChoice == 'y');
	}

	public static void displayCustomer(ArrayList<Customer> customerList) {
		// when no customers are present
		if (customerList.isEmpty()) {
			System.out.println("No customers available.");
			return;
		}
		System.out.println("*************************Customer-Account Details****************");
		System.out.printf("%-10s %-15s %-15s %-10s\n", "CustomerId", "CustomerName", "AccountType", "Balance");
		System.out.println("**************************************************************");

		for (Customer customer : customerList) {
			System.out.printf("%-10s %-15s\n", customer.getCustomerCode(), customer.getCustomerName());
			// Display account details for each customer
			ArrayList<Account> accountList = customer.getAccountList();
			for (Account account : accountList) {
				System.out.printf("%-25s %-10.2f\n", account.getAccountType(), account.getBalance());
			}
			System.out.println();
		}
	}

}