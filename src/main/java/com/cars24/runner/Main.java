package com.cars24.runner;


import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileResponse;
import com.cars24.services.impl.CustomerServiceImpl;
import com.cars24.util.DbUtil;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DbUtil.getDBconnection();
        CustomerServiceImpl customerService = new CustomerServiceImpl() ;
//        AddCustomerReq addCustomerReq = new AddCustomerReq();
//        addCustomerReq.setName("");
//        addCustomerReq.setEmail("avanii@gmail.com");
//        addCustomerReq.setPhone("2938393993");
//        addCustomerReq.setAddress("hey");
//
//        customerService.registerCustomer(addCustomerReq);


        CustomerProfileReq customerProfileReq = new CustomerProfileReq();
        customerProfileReq.setEmail("davani@gmaill.com");
        customerProfileReq.setPhone("1234567890");


        CustomerDaoImpl CustomerDaoObj1 = new CustomerDaoImpl();
        CustomerProfileResponse response=CustomerDaoObj1.GetCustomer(customerProfileReq);

        System.out.println(response);
//        System.out.println("email: "+response.getEmail());
//        System.out.println("phone number: "+response.getPhone());
//        System.out.println("name: " +response.getName());
//        System.out.println("address: "+ response.getAddress());


       // System.out.println(CustomerDaoObj1.createCustomer("avaniiisssjddj","1234567890","davani@gmaill.com","wjdjjdjd"));
    }
}


