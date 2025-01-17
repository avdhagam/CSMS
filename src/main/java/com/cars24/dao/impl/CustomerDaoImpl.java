package com.cars24.dao.impl;

import com.cars24.dao.CustomerDao;
import com.cars24.data.req.AddCustomerReq;
import com.cars24.data.req.CustomerProfileReq;
import com.cars24.data.res.CustomerProfileResponse;
import com.cars24.util.DbUtil;

import java.sql.*;


public class CustomerDaoImpl implements CustomerDao {
    private final static String INSERT_SUCCESS_MESSAGE = "Customer added successfully!";
    private final static String INSERT_ERROR_MESSAGE = "Error while adding customer";
    private final static String DELETE_SUCCESS_MESSAGE = "Customer deleted successfully";
    private final static String DELETE_ERROR_MESSAGE = "Error while deleting customer";

    @Override
    public void DeleteCustomer(CustomerProfileReq customerProfileReq){
        String deleteSQL = "DELETE FROM service_db.customers WHERE phone =? AND email = ?";
        Connection connection = DbUtil.getDBconnection();
       try {
           PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
           preparedStatement.setString(1, customerProfileReq.getPhone());
           preparedStatement.setString(2, customerProfileReq.getEmail());
           preparedStatement.executeUpdate();
           System.out.println(DELETE_SUCCESS_MESSAGE);

       } catch (SQLException e) {
           System.out.println(DELETE_ERROR_MESSAGE);
       }


    }



    @Override
    public CustomerProfileResponse GetCustomer(CustomerProfileReq customerProfileReq){
        String selectSQL = "SELECT name,email,phone,address FROM service_db.customers WHERE phone = ? OR email =?";
        Connection connection = DbUtil.getDBconnection();
        try{

            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1,customerProfileReq.getPhone());
            preparedStatement.setString(2,customerProfileReq.getEmail());
            CustomerProfileResponse response = new CustomerProfileResponse();

            ResultSet resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()){

                        response.setName(resultSet.getString("name"));
                        response.setEmail(resultSet.getString("email"));
                        response.setPhone(resultSet.getString("phone"));
                        response.setAddress(resultSet.getString("address"));

                    }
                    return response;
        }
        catch (SQLException e) {
            System.out.println("not found");
            return null;
        }

    }


    public String createCustomerv1(String name, int phone, String email, String address) {
        String insertSQL = "INSERT INTO service_db.customers (customer_id,name,phone,email,address) VALUES"
                +"("+0+","
                +"'"+name+"'"+","
                + phone +","
                +"'"+email+"'"+","
                + "'" + address+"'"+")";


        Connection connection = DbUtil.getDBconnection();
        try {
            Statement statement = connection.createStatement();
            int rowsInserted = statement.executeUpdate(insertSQL);
            System.out.println(rowsInserted + "row(s) inserted.");
        }
        catch (Exception e){
            System.out.println("Error while inserting to customer table");
            e.printStackTrace();

        }

        return "";
    }

    @Override
    public String createCustomer(AddCustomerReq addCustomerReq)  {
        try{
        Connection connection = DbUtil.getDBconnection();
        String insertSQL = "INSERT INTO service_db.customers (name,phone, email, address) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        preparedStatement.setString(1,addCustomerReq.getName());
        preparedStatement.setString(2,addCustomerReq.getPhone());
        preparedStatement.setString(3,addCustomerReq.getEmail());
        preparedStatement.setString(4,addCustomerReq.getAddress());

        int rowsInserted = preparedStatement.executeUpdate();
        return INSERT_SUCCESS_MESSAGE;
        //System.out.println(rowsInserted + "row(s) Inserted.");
    }
        catch (SQLException e) {
        e.printStackTrace();
        return INSERT_ERROR_MESSAGE;
    }

    }

    }



