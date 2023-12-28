package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;
import com.ilp.services.BankService;

public class AccountUtility {
    public static void main(String[] args) {
    	ArrayList<Service> serviceList = new ArrayList<Service>();
    	ArrayList<Product> productList = new ArrayList<Product>();
    	ArrayList<Account> accountList = new ArrayList<Account>();
    	ArrayList<Customer> customerList = new ArrayList<Customer>(); 	
        Scanner scanner = new Scanner(System.in);

        char mainMenuChoice = 'y';
        do {
            System.out.println("******Welcome To Bank************");
            System.out.println("1. Create service, 2. Create Product, 3. Create Customer, 4. Manage Accounts, 5. Display Customer, 6. Exit");
            int mainChoice = scanner.nextInt();
            switch (mainChoice) {
                case 1:
                    BankService.createService(serviceList);
                    System.out.println("Items in the serviceList:");
                    for (Service service : serviceList) {
                        System.out.println("Service Code: " + service.getServiceCode());
                        System.out.println("Service Name: " + service.getServiceName());
                        System.out.println("Rate: " + service.getRate());
                        System.out.println("----------------------------------");
                    }
                    break;
                case 2:
                	BankService.createProduct(serviceList,productList);                	
                	for (Product productService : productList) {
                        System.out.println("Service list: " + productService.toString());                      
                    }
                    break;

                case 3:
                    BankService.createCustomer(accountList,productList,customerList);                  
                    for (Account accountService : accountList) {
                        System.out.println("account list: " + accountService.toString());                      
                    }
                    
                    for (Customer customerService : customerList) {
                        System.out.println("customer list: " + customerService.toString());                    
                    }        
                    break;

                case 4:
                	BankService.manageAccounts(customerList);
                    break;

                case 5:
                	BankService.displayCustomer(customerList);
                    break;

                case 6:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
            System.out.println("Do you want to continue (y/n): ");
            mainMenuChoice = scanner.next().charAt(0);
        } while (mainMenuChoice == 'y');
        scanner.close();
    }
}

