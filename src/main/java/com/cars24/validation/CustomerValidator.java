package com.cars24.validation;

import com.cars24.data.req.AddCustomerReq;

public class CustomerValidator {
    public static void validateAddCustomerReq(AddCustomerReq addCustomerReq){
//         name shouldnt be empty, can be a min of 3 characters and a max of 100
//        if it fails in any case we shouldnt carry out the next validation
//        throw an exception manually here (custom exception)

        validateName(addCustomerReq.getName());


}
 private static void validateName(String name){
        if(name == null) {
            throw new IllegalArgumentException("Name cannot be EMPTY");
        }
        if(name.length()<3 || name.length()>100) {
            throw new IllegalArgumentException("Name should be 3 characters minimum and a 100 characters maximum");
        }

        }
 }

// public static void validatePhone(String email){
//
//}
