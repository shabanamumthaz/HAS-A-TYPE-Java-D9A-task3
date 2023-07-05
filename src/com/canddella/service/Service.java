package com.canddella.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.canddella.entity.Account;
import com.canddella.entity.Customer;

public class Service {

	public static Account createAccount() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter account number:");
		String accNum = scanner.nextLine();
		System.out.println("Enter account Type:");
		String accType = scanner.nextLine();
		System.out.println("Enter account created date:");
		String accCreateDate = scanner.nextLine();
		System.out.println("Enter account balanace:");
		double accBalance = scanner.nextDouble();

		return new Account(accNum, accType, accCreateDate, accBalance);

	}

	public static Customer createCustomer(Account account) {
		Scanner scanner = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Enter customer code:");
		String cusCode = scanner.nextLine();
		System.out.println("Enter customer Name:");
		String cusName = scanner.nextLine();
		System.out.println("Enter customer Type:");
		String cusType = scanner.nextLine();

		ArrayList<Account> accountList = new ArrayList<Account>();
		accountList.add(account);

		Customer customer = new Customer(cusCode, cusName, cusType, accountList);

		return customer;
	}

	public static void displayAccount(ArrayList<Customer> customerList) {

		for (Customer customer : customerList) {
			if (customer != null) {
				System.out.println("***********Details***********");
				System.out.println("Customer code:    " + customer.getCustomerCode() + "\nCustomer Name:    "
						+ customer.getCustomerName() + "\nCustomer Type:    " + customer.getCustomerType());
				for (Account account : customer.getAccountList()) {
					if (account != null) {
						System.out.println("Account Number:      " + account.getAccountNo() + "\nAccount Type:    "
								+ account.getAccountType() + "\nAccount Create Date:    "
								+ account.getAccountCreateDate() + "\nAccount Balance:    " + account.getBalance());
					}

				}

			}
		}

	}

	public static void addMultipleAccount(ArrayList<Customer> customerList) {
		Scanner scanner = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Enter Customer Id:");
		String cusId = scanner.nextLine();
		for (Customer customer : customerList) {
			if (customer != null) {
				if (cusId.equalsIgnoreCase(customer.getCustomerCode())) {
					customer.getAccountList().add(Service.createAccount());
				}
			}
		}

	}

}
