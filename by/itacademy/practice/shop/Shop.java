package by.itacademy.practice.shop;

import java.util.Arrays;
import java.util.Scanner;

public class Shop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = 5;
		Customer[] customer = new Customer[n];

		customer[0] = new Customer("Orlov", "Oleg", "Viktorovich");
		customer[1] = new Customer("Petrov", "Egor", "Alexandrovich");
		customer[2] = new Customer("Lavinova", "Alena", "Ivanovna");
		customer[3] = new Customer("Lavinova", "Irina", "Ivanovna");
		customer[4] = new Customer("Pavlov", "Oleg", "Ivanovich");

		while (true) {
			System.out.print("�������� ����� ����: \n" + "0. �����\n" + "1. ����� ������ ���� �����������\n"
					+ "2. ����� ������ ����������� � ���������� �������\n"
					+ "3. ����� ������ ����������� � ��������� ������ � ������������ ���������\n>> ");
			int choice = scanner.nextInt();
			if (choice == 0) {
				break;
			}
			if (choice < 1 || choice > 3) {
				System.out.println("������ �������������� ����� ����. ��������� �����: ");
				continue;
			}
			System.out.println("**********************");
			switch (choice) {
			case 1:
				System.out.println("��� ����������: ");
				for (int i = 0; i < customer.length; i++) {
					customer[i].print();
				}
				while (true) {
					System.out.print("�������� ����� ����: \n" + "1. ��������� �����\n" + "2. �������� "
							+ "������ ����������\n>> ");
					int choiceTwo = scanner.nextInt();
					if (choiceTwo < 1 || choiceTwo > 2) {
						System.out.println("������ �������������� ����� ����. ��������� �����: ");
						continue;
					}
					System.out.println("**********************");
					switch (choiceTwo) {
					case 1:
						break;
					case 2:
						System.out.print("������� id-����� ����������\n>> ");
						int enteredId = scanner.nextInt();

						System.out.print("�������� ����� ����: \n" + "1. ��������� �����\n"
								+ "2. �������� ����� ����� ����������\n>> ");
						int choiceThree = scanner.nextInt();
						System.out.println("**********************");
						switch (choiceThree) {
						case 1:
							break;
						case 2:
							System.out.println("������� ����� ����� ����� ����������:");
							long newCardNumber = scanner.nextLong();
							int i = Customer.toFindCustomer(enteredId, customer);
							customer[i].setCreditCardNumber(String.valueOf(newCardNumber));
							System.out.println("����� ����� ���������� " + customer[i].getId() + " ������� �������.");
						}
						break;
					}
					break;
				}
			case 2:
				System.out.println("������ �����������, ��������������� �� ��������: ");
				Arrays.sort(customer, Customer.NameComparator);
				for (int i = 0; i < customer.length; i++) {
					customer[i].print();
				}
				break;
			case 3:
				System.out.println("������� �������� ��������� ���� ��� ��������:");
				System.out.println("��: ");
				String from = "";
				long enteredFirstCardNumber = scanner.nextLong();
				System.out.println("��: ");
				String to = "";
				long enteredSecondCardNumber = scanner.nextLong();
				if (enteredFirstCardNumber <= enteredSecondCardNumber) {
					from = Customer.toConvertInCardNumber(enteredFirstCardNumber);
					to = Customer.toConvertInCardNumber(enteredSecondCardNumber);
				} else {
					from = Customer.toConvertInCardNumber(enteredSecondCardNumber);
					to = Customer.toConvertInCardNumber(enteredFirstCardNumber);
				}
				System.out.println("������ ��������, � ������� ����� ��������� �������� ��������� � ���������: ");
				System.out.println("�� " + from + " �� " + to + " :");
				Customer.printCustomerIfCreditCardFromTo(from, to, n, customer);
				System.out.println("**********************");
				break;
			}

		}
		scanner.close();
	}
}
