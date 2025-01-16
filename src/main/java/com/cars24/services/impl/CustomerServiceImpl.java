package com.cars24.services.impl;

import com.cars24.dao.impl.CustomerDaoImpl;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileResponse;
import com.cars24.services.CustomerService;
import com.cars24.validation.CustomerValidator;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDaoImpl customerDao = new CustomerDaoImpl();

    @Override
    public String registerCustomer(AddCustomerReq addCustomerReq) {
        try {
            customerDao.createCustomer(addCustomerReq);
            CustomerValidator.validateAddCustomerReq(addCustomerReq);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return  null;
    }

    @Override
    public CustomerProfileResponse getCustomerProfile(CustomerProfileReq customerProfileReq) {
        return null;
    }

   /* @Override
    public String updateCustomer(AddCustomerReq addCustomerReq){
        customerDao.updateCustomer(addCustomerReq);
        return null;
    }

    */



}
