package app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the program for entering and displaying customers data!\n");
        Scanner enter = new Scanner(System.in);
        System.out.print("Enter the number of the customers: ");
        int numberCustomers = enter.nextInt();
        enter.nextLine();
        System.out.print("\n");
        int count = 1;

        while (count <= numberCustomers) {

            System.out.print("Enter the name of the customer: ");
            String name = enter.nextLine();

            if (isCorrectName(name)) {
                System.out.println("The entered name is correct!");
                System.out.print("\n");
            } else {
                System.out.println("The entered name is incorrect!");
                System.out.print("\n");
                continue;
            }

            System.out.print("Enter the phone of the customer: ");
            String phone = enter.nextLine();

            System.out.print("\n");
            Customer customer = getCustomer(getData(name, phone));
            String output = String.format("Customer: %s, phone: %s", customer.getName(), customer.getPhone());
            getOutput(output);
            System.out.print("\n");

            if (isCorrectName(name) && isCorrectPhone(phone)) {
                count++;
            }
        }

        System.out.println("Date entry is complete!\nAlways happy to help!");
    }

    public static boolean isCorrectName(String name) {
        char[] arrayName = name.toCharArray();
        char[] arraySymbols = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ',
                '~', '!', '?', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+',
                '=', '№', '.', ',', '/', '{', '}', '[', ']', ';', ':', '<', '>', '|'};

        for (int i : arrayName) {

            for (int j : arraySymbols) {

                if (i == j) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isCorrectPhone(String phone) {
        String phoneNew = phone.toLowerCase();
        char[] arrayPhone = phoneNew.toCharArray();
        char[] arraySymbols = {'~', '!', '?', '@', '#', '$', '%', '^', '&', '*', '(',
                ')', '+', '=', '№', '.', ',', '/', '{', '}', '[', ']', ';', ':', '<',
                '>', '|', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int i : arrayPhone) {

            for (int j : arraySymbols) {

                if (i == j) {
                    return false;
                }

            }
        }
        return true;
    }

    public static String[] getData(String name, String phone) {
        return new String[]{name, phone};
    }

    public static Customer getCustomer(String[] data) {
        return new Customer(data[0], data[1]);
    }

    public static void getOutput(String output) {
        System.out.println(output);
    }
}