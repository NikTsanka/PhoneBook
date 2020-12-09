package com.ntsan.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

    List<Contact> contactList = new ArrayList<>();

    public void showMenu() {
        System.out.println("--------###### M E N U ######---------");
        System.out.println("Welcome to PhoneBook application. Please choose operation: ");
        System.out.println("1. List contacts");
        System.out.println("2. Add contact");
        System.out.println("3. Edit contact");
        System.out.println("4. Remove contact");
        System.out.println("5. EXIT");
    }

    void run() {
        Scanner scanner = new Scanner(System.in);

        do {
            showMenu();
            int number = scanner.nextInt();

            switch (number) {
                case 1:
                    listContacts();
                    break;
                case 2:
                    addContact(scanner);
                    break;
                case 3:
                    editContact(scanner);
                    break;
                case 4:
                    removeContact(scanner);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }

        } while (true);

    }

    public Contact addContact(Scanner scanner) {
        System.out.println("Please, fill in name, last name, phone number with spaces between: ");
        String firstName = scanner.next();
        String lastName = scanner.next();
        String phoneNumber = scanner.next();
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contactList.add(contact);
        return contact;
    }

    public void removeContact(Scanner scanner) {
        System.out.println("Provide the index of contact to remove: ");
        int index = scanner.nextInt();
        contactList.remove(index);
        System.out.println("Contact is removed\n");
    }

    public void editContact(Scanner scanner) {
        System.out.println("Provide the index of contact to edit: ");
        int index = scanner.nextInt();
        Contact contactToEdit = contactList.get(index);
        System.out.println("Please, fill in name, last name, phone number with spaces between: ");
        String firstName = scanner.next();
        String lastName = scanner.next();
        String phoneNumber = scanner.next();
        contactToEdit.setFirstName(firstName);
        contactToEdit.setLastName(lastName);
        contactToEdit.setPhoneNumber(phoneNumber);
    }

    public void listContacts() {

        if (contactList.isEmpty()) {
            System.out.println("List is empty. Please add contact with operation '2': \n");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.print("Index " + i + ": ");
                System.out.println(contactList.get(i));
            }
        }
    }

}