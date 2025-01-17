package com.cars24.runner;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileResponse;
import com.cars24.services.impl.CustomerServiceImpl;

import java.util.Scanner;

public class UI {
    private final static Scanner scanner  = new Scanner(System.in);
    public static void addCustomer()
    {
        System.out.println("Enter customer details");
        AddCustomerReq addCustomerReq = new AddCustomerReq();

        System.out.println("Enter your email: ");
        addCustomerReq.setEmail(scanner.next());
        System.out.println("Enter your phone number: ");
        addCustomerReq.setPhone(scanner.next());
        System.out.println("Enter your name: ");
        addCustomerReq.setName(scanner.next());
        System.out.println("Enter your address: ");
        addCustomerReq.setAddress(scanner.next());

        CustomerServiceImpl customerService = new CustomerServiceImpl() ;
        customerService.registerCustomer(addCustomerReq);
    }

    public static void getCustomer()
    {
        System.out.println("Search customer details");
        CustomerProfileReq customerProfileReq = new CustomerProfileReq();

        System.out.println("Enter Email  : ");
        customerProfileReq.setEmail(scanner.next());
        System.out.println("Enter Phone  : ");
        customerProfileReq.setPhone(scanner.next());

        CustomerServiceImpl customerService = new CustomerServiceImpl();
        CustomerProfileResponse response =  customerService.getCustomerProfile(customerProfileReq);
        System.out.println(response);


    }

    public static void removeCustomer(){
        System.out.println(" Enter the following details of the customer to be deleted");
        CustomerProfileReq customerProfileReq = new CustomerProfileReq();

        System.out.println("Enter Email  : ");
        customerProfileReq.setEmail(scanner.next());
        System.out.println("Enter Phone  : ");
        customerProfileReq.setPhone(scanner.next());

        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.deleteCustomer(customerProfileReq);
        

    }
}
