package com.canddella.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.canddella.entity.Account;
import com.canddella.entity.Customer;
import com.canddella.service.Service;

public class Utility {

	public static void main(String[] args) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Scanner scanner = new Scanner(System.in);

		boolean decision = false;

		do {
			System.out.println("******Menu******");
			System.out.println("1.Create Account\n2.Display Account\n3.Add Multiple Account\n4.Exit");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				Account account = Service.createAccount();
				customerList.add(Service.createCustomer(account));

				break;
			case 2:
				Service.displayAccount(customerList);
				break;
			case 3:
				Service.addMultipleAccount(customerList);

				break;
			case 4:
				break;
			default:
				break;
			}
			System.out.println("Do you want to continue?\n1.Yes    2No");
			int ans = scanner.nextInt();
			if (ans == 1) {
				decision = true;
			} else if (ans == 2) {
				decision = false;
			} else
				System.out.println("Invalid Input:");

		} while (decision);

	}
}