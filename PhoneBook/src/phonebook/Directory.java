package phonebook;

public class Directory {

	Person[] book = new Person[0];

	public void addPerson(Person newPerson) {
		Person[] temp = new Person[book.length + 1];
		for (int i = 0; i < book.length; i++) {
			temp[i] = book[i];
		}
		temp[temp.length - 1] = newPerson;
		book = temp;
	}

	public void deletePerson(Person removed) {
		Person[] temp = new Person[book.length - 1];
		int x = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i] != removed) {
				temp[x] = book[i];
				x++;
			}
		}
		book = temp;
	}

	public Person[] getDirectory() {
		return book;
	}

	public void printDirectory() {
		for (int i = 0; i < book.length; i++) {
			book[i].printPerson();
		}
	}

	public void printPersonArray(Person[] searched) {
		for (int i = 0; i < searched.length; i++) {
			searched[i].printPerson();
		}
	}

	public Person searchByPhone(long phoneNum) {
		int index = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].getPhoneNum() == phoneNum) {
				index = i;
				break;
			}
		}
		return book[index];
	}

	public Person[] getByLastName(String lastName) {
		// set counter for the size of the array
		int counter = 0;
		// for loop to see how many people have the same Last name
		for (int i = 0; i < book.length; i++) {
			if (book[i].getLastName().equals(lastName)) {
				counter++;
			}
		}
		// make a temp array that is the exact size of how many names were found
		Person[] temp = new Person[counter];

		// set another counter that will use the index value
		int x = 0;

		for (int i = 0; i < book.length; i++) {
			if (book[i].getLastName().equals(lastName)) {
				temp[x] = book[i];
				x++;
			}
		}
		return temp;
	}

	public Person[] getByFirstName(String firstName) {
		// set counter for the size of the array
		int counter = 0;
		// for loop to see how many people have the same first name
		for (int i = 0; i < book.length; i++) {
			if (book[i].getFirstName().equals(firstName)) {
				counter++;
			}
		}
		// make a temp array that is the exact size of how many names were found
		Person[] temp = new Person[counter];

		// set another counter that will use the index value
		int x = 0;

		for (int i = 0; i < book.length; i++) {
			if (book[i].getFirstName().equals(firstName)) {
				temp[x] = book[i];
				x++;
			}
		}
		return temp;
	}



}
