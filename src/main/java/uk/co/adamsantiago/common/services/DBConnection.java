package uk.co.adamsantiago.common.services;

import org.apache.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

    final static Logger logger = Logger.getLogger(DBConnection.class);

    private String connectionString;
    private Connection connection;
    private static String HOSTNAME = System.getenv("DB_HOSTNAME");
    private static String PORT = System.getenv("DB_PORT");
    private static String DATABASE = System.getenv("DB_NAME");
    private static String USERNAME = System.getenv("DB_USERNAME");
    private static String PASSWORD = System.getenv("DB_PASSWORD");

    public DBConnection() {
        connectionString = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DATABASE;
        try {
            this.connection = DriverManager.getConnection(connectionString, USERNAME, PASSWORD);
        } catch (SQLException sqle) {
            logger.error("Failed to connect to database using connection string: " + connectionString);
            logger.debug(sqle.toString());
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            if (query.startsWith("INSERT") || query.startsWith("UPDATE") || query.startsWith("DELETE")) {
                statement.executeUpdate(query, 1);
                return statement.getGeneratedKeys();
            } else {
                return statement.executeQuery(query);
            }
        } catch (SQLException sqle) {
            logger.error("Failed to execute query: " + query);
            logger.debug(sqle.toString());
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
            logger.error("Failed to execute the query: " + queries);
            logger.debug(sqle.toString());
            return null;
        }
    }

    public void close() {
        try {
            this.connection.close();
        } catch(SQLException sqle) {
            logger.error("Error closing connection");
            logger.debug(sqle.toString());
        }
    }
}
