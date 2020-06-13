package com.medicalcorp;

import java.sql.*;

public class BDW1 {
    private static final String URL ="jdbc:mysql://localhost:3306/bd_medicalcorp";
    private static final String USER = "root";
    private static final String PASS  ="root";

    private  Connection connection;

    public BDW1() {


        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установлено");
            }
            Statement statement = connection.createStatement();

        } catch (SQLException e){
            System.err.println("Не удалось соединиться с БД");
        }
    }

    public  Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
