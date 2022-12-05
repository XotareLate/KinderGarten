package com.example.kindergarten;

import java.sql.*;
import java.util.ArrayList;


public class Database extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionSrting = "jdbc:mysql//localhost:3306/groups" ;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionSrting,dbUser, dbPass);
        return dbConnection;
    }

    public void insertTask(String task) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO 'todo' (task) VALUES (?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, task);
        prSt.executeUpdate();

    }
    public ArrayList<String> getTasks() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM TODO ORDER BY 'id'";
        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        ArrayList<String> tasks = new ArrayList<>();
        while(res.next()) {
            tasks.add(res.getString("task"));
        }
        return tasks;
    }
}
