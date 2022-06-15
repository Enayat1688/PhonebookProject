package phonebook;

import java.util.*;

public class PhoneBookMain {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Person p1 = new Person(13146493662L, "Brandon", "Owens", "Jakob");
		p1.addAddress(4356, "Lindell Blvd.", "St. Louis", "MO", 63108);
		p1.printPerson();

		Person p2 = new Person(12342332323L, "Enayat", "Enayat", null);
		p2.addAddress(123, "Mockingbird Lane", "St. Louis", "MO", 63123);
		p2.printPerson();

		Directory d1 = new Directory();
		d1.addPerson(p1);
		d1.addPerson(p2);
		int choice = 0;
		while (choice != 11) {
			choice = getMenu();
			switch (choice) {
			case 1:
				System.out.println("Enter person information separated by commas");
				System.out.println("FORMAT: Name, Street Address, City, State, Zip, Phone Number");
				String info = input.nextLine();

				String[] tempInfo = info.split(", ");
				String name = tempInfo[0];
				String street = tempInfo[1];
				String city = tempInfo[2];
				String state = tempInfo[3];
				int zipCode = Integer.parseInt(tempInfo[4]);
				long phoneNum = Long.parseLong(tempInfo[5]);

				String[] tempName = name.split(" ");
				String fName = tempName[0];
				String lName = tempName[tempName.length - 1];

				// empty container to hold the middle name
				String middleName = "";
				for (int i = 1; i < tempName.length - 1; i++) {
					middleName += tempName[i];
					if (i != tempName.length - 2) {
						middleName += " ";
					}
				}

				String[] tempAddress = street.split(" ");
				int streetNum = Integer.parseInt(tempAddress[0]);
				String streetName = "";

				for (int i = 1; i < tempAddress.length; i++) {
					streetName = tempAddress[i];
					if (i != tempAddress.length - 1) {
						streetName = " ";
					}
				}

				Person p3 = new Person(phoneNum, fName, lName, middleName);
				p3.addAddress(streetNum, streetName, city, state, zipCode);
				d1.addPerson(p3);
				d1.printDirectory();
				break;
			case 2:
				System.out.println("Please enter the phonenumber of the person you want to delete");
				long case2 = input.nextLong();
				d1.deletePerson(d1.searchByPhone(case2));
				d1.printDirectory();
				break;
			case 3:
				System.out.println("Enter the first name of the person you are searching for");
				String case3 = input.next();
				d1.printPersonArray(d1.getByFirstName(case3));
				break;
			case 4:
				System.out.println("Enter the last name of the person you are searching for");
				String case4 = input.next();
				d1.printPersonArray(d1.getByLastName(case4));
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				break;
			case 11:
				System.exit(0);
				break;
			}
		}
	}

	public static int getMenu() {
		Scanner sc1 = new Scanner(System.in);
		// print menu
		System.out.println("1. Add new person");
		System.out.println("2. Delete new person");
		System.out.println("3. Search by first name");
		System.out.println("4. Search by last name");
		System.out.println("5. Search by full name");
		System.out.println("6. Search by phone number");
		System.out.println("7. Search by city");
		System.out.println("8. Search by state");
		System.out.println("9. Sort people alphabetically");
		System.out.println("10. Update person information");
		System.out.println("11. End the program");
		System.out.println("Please enter a number");

		int choice = sc1.nextInt();
		System.out.println();
		return choice;
	}

}
