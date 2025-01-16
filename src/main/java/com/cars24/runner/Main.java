package com.cars24.runner;

import com.cars24.runner.UI;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = true;

        while (true){
            System.out.println("enter choice");
            System.out.println("0 to exit");
            System.out.println("1 to add details");
            System.out.println("2 to get details");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    UI.addCustomer();
                    break;
                // call
                case 2:
                    UI.getCustomer();
                    break;
                case 0:
                    exit =false;
                    break;
            }
        }

    }

}

