package app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the program for entering and displaying customers data!\n");
        System.out.print("Enter the number of the customers: ");
        Scanner enter = new Scanner(System.in);
        int numberCustomers = enter.nextInt();
        enter.nextLine();
        System.out.println();

        int count = 1;

        while (count <= numberCustomers) {
            String name;

            while (true) {
                System.out.print("Enter the name of the customer: ");
                name = enter.nextLine();
                if (isCorrectName(name)) {
                    System.out.println("The entered name is correct!\n");
                    break;
                }
                System.out.println("The entered name is incorrect!\n");
            }

            String phone;

            while (true) {
                System.out.print("Enter the phone of the customer: ");
                phone = enter.nextLine();
                if (isCorrectPhone(phone)) {
                    System.out.println("The entered number of the phone is correct!\n");
                    break;
                }
                System.out.println("The entered number of the phone is incorrect!\n");
            }

            Customer customer = new Customer(name, phone);
            String output = String.format("Customer: %s, phone: %s \n", customer.getName(), customer.getPhone());
            getOutput(output);

            count++;
        }
        System.out.println("Date entry is complete!\nAlways happy to help!");
    }

    public static boolean isCorrectName(String name) {
        for (char simbolName : name.toCharArray()) {
            if (!Character.isLetter(simbolName)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCorrectPhone(String phone) {
        for (char simbolPhone : phone.toCharArray()) {
            if (!Character.isDigit(simbolPhone)) {
                return false;
            }
        }
        return true;
    }

    public static void getOutput(String output) {
        System.out.println(output);
    }
}