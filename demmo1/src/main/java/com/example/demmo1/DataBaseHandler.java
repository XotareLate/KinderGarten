package com.example.demmo1;

import java.sql.*;

public class DataBaseHandler{

    private static final String url = "jdbc:mysql://localhost:3306/demmo";
    private static final String user = "root";
    private static final String password = "Neket_2003";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Connection connection;

    public DataBaseHandler() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;
    }

    public void singUpChild(String childName, String childSecondName,String childThirdName, String childGender, String childAge, String childGroup){
        String insert = "INSERT INTO Child(childName,childSecondName,childThirdName,childGender,childAge,childGroup) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setString(1,childName);
            preparedStatement.setString(2,childSecondName);
            preparedStatement.setString(3,childThirdName);
            preparedStatement.setString(4,childGender);
            preparedStatement.setString(5,childAge);
            preparedStatement.setString(6,childGroup);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void singUpGroup(String groupName){
        String insert = "INSERT INTO Group(groupName) VALUES(?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(insert);
            preparedStatement.setString(1,groupName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}