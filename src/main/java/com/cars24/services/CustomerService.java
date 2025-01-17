package com.cars24.services;

import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileResponse;

public interface CustomerService {
     String registerCustomer(AddCustomerReq addCustomerReq);
     CustomerProfileResponse getCustomerProfile(CustomerProfileReq customerProfileReq);
     void deleteCustomer(CustomerProfileReq customerProfileReq);

}
