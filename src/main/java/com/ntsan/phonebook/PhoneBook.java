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

    public void addContact(Scanner scanner) {
        System.out.println("Please, fill in name, last name, phone number with spaces between: ");
        String firstName = scanner.next();
        //System.out.println("Please enter contact last name: ");
        String lastName = scanner.next();
        //System.out.println("Please enter contact number: ");
        String phoneNumber = scanner.next();
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contactList.add(contact);
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
        System.out.println("Please, fill in name, last name, phone number with spaces between: ");
        String firstName = scanner.next();
        // System.out.println("Please enter contact last name: ");
        String lastName = scanner.next();
        // System.out.println("Please enter contact number: ");
        String phoneNumber = scanner.next();
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contactList.set(index, contact);
    }

    public void listContacts() {

        if (contactList.isEmpty()) {
            System.out.println("List is empty. Please add contact with index 2: \n");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.print("Index " + i + ": ");
                System.out.println(contactList.get(i));
            }
        }
    }

}
