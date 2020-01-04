package uk.co.adamsantiago.common.services;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

    private String connectionString;
    private Connection connection;
    private static String HOSTNAME = "adam.cbxucjjqy5m3.eu-west-1.rds.amazonaws.com";
    private static String PORT = "3306";
    private static String DATABASE = "ashilda";
    private static String USERNAME = "admin";
    private static String PASSWORD = "Carla890";
    private static String COMPATABILITY_PARAMETERS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public DBConnection() {
        connectionString = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DATABASE + COMPATABILITY_PARAMETERS;
        try {
            this.connection = DriverManager.getConnection(connectionString, USERNAME, PASSWORD);
        } catch (SQLException sqle) {
            System.out.println("Failed to connect to database using connection string: " + connectionString);
        }
    }

    public DBConnection(String hostname, String port, String database) {
        connectionString = "jdbc:mysql://" + hostname + ":" + port + "/" + database + COMPATABILITY_PARAMETERS;
        try {
            this.connection = DriverManager.getConnection(connectionString, USERNAME, PASSWORD);
        } catch (SQLException sqle) {
            System.out.println("Failed to connect to database using connection string: " + connectionString);
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            if (query.startsWith("INSERT") || query.startsWith("UPDATE")) {
                statement.executeUpdate(query, 1);
                return statement.getGeneratedKeys();
            } else {
                return statement.executeQuery(query);
            }
        } catch (SQLException sqle) {
            System.out.println("Failed to execute the query: " + query);
            return null;
        }
    }

    public int[] executeQueries(ArrayList<String> queries) {
        try {
            Statement statement = connection.createStatement();
            for(String query : queries) {
                statement.addBatch(query);
            }
            return statement.executeBatch();
        } catch (SQLException sqle) {
            System.out.println("Failed to execute the query: " + queries);
            return null;
        }
    }

    public void close() {
        try {
            this.connection.close();
        } catch(SQLException sqle) {
            System.out.println("Error closing connection");
        }
    }
}
