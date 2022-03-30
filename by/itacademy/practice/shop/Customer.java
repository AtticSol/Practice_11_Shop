package by.itacademy.practice.shop;

import java.util.Comparator;
import java.util.Random;

public class Customer implements Comparable<Customer> {
	private int id;
	private String lastName;
	private String name;
	private String middleName;
	private String creditCardNumber;
	private String bankAccountNumber;

	public Customer(String lastName, String name, String middleName) {
		id = getId();
		this.lastName = lastName;
		this.name = name;
		this.middleName = middleName;
		creditCardNumber = getCreditCardNumber();
		bankAccountNumber = getBankAccountNumber();
	}

	public int getId() {
		Random rand = new Random();
		id = rand.nextInt(1000);
		if (String.valueOf(id).length() < 4) {
			setId(id);
		}
		return id;
	}

	public void setId(int idc) {
		if (String.valueOf(idc).length() < 4) {
			idc = idc * 10;
			this.id = idc;
			setId(idc);
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getCreditCardNumber() {
		creditCardNumber = "";
		Random rand = new Random();
		int i = 0;
		while (i < 4) {
			int fourDigitsOfCardNumber = rand.nextInt(9999);
			String part = String.valueOf(fourDigitsOfCardNumber);
			if (part.length() < 4) {
				part = "0" + part;
			}
			creditCardNumber += part + " ";
			i++;
		}
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		if (creditCardNumber.length() != 16) {
			throw new RuntimeException("Íîìåð êðåäèòíîé êàðòû ââåäåí íåâåðíî");
		}
		creditCardNumber = creditCardNumber.substring(0, 4) + " " + creditCardNumber.substring(4, 8) + " "
				+ creditCardNumber.substring(8, 12) + " " + creditCardNumber.substring(12, 16);
		this.creditCardNumber = creditCardNumber;
	}

	public String getBankAccountNumber() {
		bankAccountNumber = "";
		Random rand = new Random();
		int i = 0;
		while (i < 4) {
			int fourDigitsOfBankAccountNumber = rand.nextInt(9999);
			String part = String.valueOf(fourDigitsOfBankAccountNumber);
			if (part.length() < 4) {
				part = "0" + part;
			}
			bankAccountNumber += part;
			i++;
		}
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		if (bankAccountNumber.length() < 16 || bankAccountNumber.length() > 34) {
			throw new RuntimeException("Íîìåð áàíêîâñêîãî ñ÷åòà ââåäåí íåâåðíî");
		}
		this.bankAccountNumber = bankAccountNumber;
	}

	public String toString() {
		String s = "id = " + id + " - " + lastName + " " + name + " " + middleName + ". Íîìåð êàðòû: " + creditCardNumber
				+ ". Íîìåð ñ÷åòà: " + bankAccountNumber;
		return s;

	}

	public void print() {
		System.out.println(toString());
	}

	public static class ByNameComparator implements Comparator<Customer> {
		@Override
		public int compare(Customer left, Customer right) {
			if (left.lastName != right.lastName){
				return left.lastName.compareTo(right.lastName);
			}
			if (left.name != right.name){
				return left.name.compareTo(right.name);
			}
			return left.middleName.compareTo(right.middleName);
		}
	}

	public static void sortByName() {

	}

	@Override
	public int compareTo(Customer o) {
		return (this.id - o.id);
	}

	public static Comparator<Customer> NameComparator = new Comparator<Customer>() {

		@Override
		public int compare(Customer left, Customer right) {
			if (left.lastName != right.lastName)
				return left.getLastName().compareTo(right.getLastName());
			if (left.name != right.name)
				return left.getName().compareTo(right.getName());
			return left.getMiddleName().compareTo(right.getMiddleName());
		}
	};

	public static void printCustomerIfCreditCardFromTo(String a, String b, int n, Customer[] customer) {
		boolean isCardNumber = false;
		for (int i = 0; i < n; i++) {
			if (customer[i].creditCardNumber.compareTo(a) >= 0 && customer[i].creditCardNumber.compareTo(b) <= 0) {
				isCardNumber = true;
				customer[i].print();
			}
		}
		if (isCardNumber == false) {
			System.out.println("Ïîêóïàòåëåé ñ òàêèìè êàðòàìè íåò.");
		}
	}

	public static String toConvertInCardNumber(long enteredCardNumber) {
		String convertedCardNumber = "";
		while (String.valueOf(enteredCardNumber).length() < 16) {
			enteredCardNumber = enteredCardNumber * 10;
		}
		convertedCardNumber = String.valueOf(enteredCardNumber);
		convertedCardNumber = convertedCardNumber.substring(0, 4) + " " + convertedCardNumber.substring(4, 8) + " "
				+ convertedCardNumber.substring(8, 12) + " " + convertedCardNumber.substring(12, 16);
		return convertedCardNumber;
	}

	public static int toFindCustomer(int enteredId, Customer[] customer) {
		int j = 0;
		for (int i = 0; i < customer.length; i++) {
			if (customer[i].id == enteredId) {
				j = i;
			}
		}
		if (j == 0 && customer[0].id != enteredId) {
			throw new RuntimeException("Ïîêóïàòåëÿ ñ òàêèì id íåòó");
		}
		return j;
	}

}
