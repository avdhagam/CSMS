package com.cars24.util;

import com.cars24.config.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static Connection dbconnection ;
    public static Connection getDBconnection(){
        if (dbconnection == null) {
            try {
                dbconnection = DriverManager.getConnection(DbConfig.host, DbConfig.username, DbConfig.password);
                // establishes connection bw java port and db
                System.out.println("Connection successful");

            } catch (SQLException e) {
                System.out.println("Error connecting to the db");
                throw new RuntimeException(e);
            }
        }
                return dbconnection;


    }
}
