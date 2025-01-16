package com.cars24.dao;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileResponse;

public interface CustomerDao {
    public String createCustomer(AddCustomerReq addCustomerReq);

    public CustomerProfileResponse GetCustomer(CustomerProfileReq customerProfileReq);

    //public void UpdateCustomer();
    //public void DeleteCustomer();
}







