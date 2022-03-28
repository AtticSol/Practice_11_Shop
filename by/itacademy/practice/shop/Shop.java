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
			System.out.print("¬ыберите пункт меню: \n" + "0. выйти\n" + "1. вывод списка всех покупателей\n"
					+ "2. вывод списка покупателей в алфавитном пор€дке\n"
					+ "3. вывод списка покупателей с кредитной картой в определенном интервале\n>> ");
			int choice = scanner.nextInt();
			if (choice == 0) {
				break;
			}
			if (choice < 1 || choice > 3) {
				System.out.println("¬ыбран несуществующий пункт меню. ѕовторите выбор: ");
				continue;
			}
			System.out.println("**********************");
			switch (choice) {
			case 1:
				System.out.println("¬се покупатели: ");
				for (int i = 0; i < customer.length; i++) {
					customer[i].print();
				}
				while (true) {
					System.out.print("¬ыберите пункт меню: \n" + "1. вернутьс€ назад\n" + "2. изменить "
							+ "данные покупател€\n>> ");
					int choiceTwo = scanner.nextInt();
					if (choiceTwo < 1 || choiceTwo > 2) {
						System.out.println("¬ыбран несуществующий пункт меню. ѕовторите выбор: ");
						continue;
					}
					System.out.println("**********************");
					switch (choiceTwo) {
					case 1:
						break;
					case 2:
						System.out.print("¬ведите id-номер покупател€\n>> ");
						int enteredId = scanner.nextInt();

						System.out.print("¬ыберите пункт меню: \n" + "1. вернутьс€ назад\n"
								+ "2. изменить номер карты покупател€\n>> ");
						int choiceThree = scanner.nextInt();
						System.out.println("**********************");
						switch (choiceThree) {
						case 1:
							break;
						case 2:
							System.out.println("¬ведите новый номер карты покупател€:");
							long newCardNumber = scanner.nextLong();
							int i = Customer.toFindCustomer(enteredId, customer);
							customer[i].setCreditCardNumber(String.valueOf(newCardNumber));
							System.out.println("номер карты покупател€ " + customer[i].getId() + " успешно изменен.");
						}
						break;
					}
					break;
				}
			case 2:
				System.out.println("—писок покупателей, отсортированный по алфавиту: ");
				Arrays.sort(customer, Customer.NameComparator);
				for (int i = 0; i < customer.length; i++) {
					customer[i].print();
				}
				break;
			case 3:
				System.out.println("¬ведите диапазон кредитных карт без пробелов:");
				System.out.println("ќт: ");
				String from = "";
				long enteredFirstCardNumber = scanner.nextLong();
				System.out.println("ƒо: ");
				String to = "";
				long enteredSecondCardNumber = scanner.nextLong();
				if (enteredFirstCardNumber <= enteredSecondCardNumber) {
					from = Customer.toConvertInCardNumber(enteredFirstCardNumber);
					to = Customer.toConvertInCardNumber(enteredSecondCardNumber);
				} else {
					from = Customer.toConvertInCardNumber(enteredSecondCardNumber);
					to = Customer.toConvertInCardNumber(enteredFirstCardNumber);
				}
				System.out.println("—писок клиентов, у которых номер кредитной карточки находитс€ в интервале: ");
				System.out.println("от " + from + " до " + to + " :");
				Customer.printCustomerIfCreditCardFromTo(from, to, n, customer);
				System.out.println("**********************");
				break;
			}

		}
		scanner.close();
	}
}
