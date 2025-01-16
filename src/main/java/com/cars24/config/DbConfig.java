package com.cars24.config;


public class DbConfig {


//    public static final String host = DB_HOST;
//    public static final String username = DB_USERNAME;
//    public static final String password = DB_PASSWORD;
//    public static final String dbname = DB_NAME;

    public static final String host = System.getenv("DB_HOST");
    public static final String username = System.getenv("DB_USERNAME");
    public static final String password = System.getenv("DB_PASSWORD");
    public static final String dbname = System.getenv("DB_NAME");



}
