package uk.co.adamsantiago.common.models;

import java.util.ArrayList;

public abstract class Statement {

    protected static String SELECT = "SELECT";
    protected static String INSERT_INTO = "INSERT INTO";
    protected static String DELETE = "DELETE";
    protected static String UPDATE = "UPDATE";
    protected static String SET = "SET";
    protected static String FROM = "FROM";
    protected static String WHERE = "WHERE";
    protected static String VALUES = "VALUES";
    protected static String AND = "AND";
    protected static String LEFT_BRACKET = "(";
    protected static String RIGHT_BRACKET = ")";
    protected static String EQUALS = "=";
    protected static String SPACE = " ";
    protected static String COMMA = ",";
    protected static String APOSTROPHE = "'";
    protected static String SEMICOLON = ";";

    protected String statement;

    public Statement() {
        statement = "";
    }

    protected static String generateSelectColumnsList(ArrayList<String> columns) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < columns.size(); i++) {
            sb.append(columns.get(i));
            if (i != (columns.size()-1)) {
                sb.append(COMMA);
                sb.append(SPACE);
            }
        }
        return sb.toString();
    }

    protected static String generateSelectConditionsList(ArrayList<String> columns, ArrayList<String> values) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < columns.size(); i++) {
            sb.append(columns.get(i));
            sb.append(EQUALS);
            sb.append(values.get(i));
            if (i != (columns.size()-1)) {
                sb.append(SPACE);
                sb.append(AND);
                sb.append(SPACE);
            }
        }
        return sb.toString();
    }

    protected static String generateInsertList(ArrayList<String> items) {
        StringBuffer sb = new StringBuffer();
        sb.append(LEFT_BRACKET);
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i));
            if (i != (items.size()-1)) {
                sb.append(COMMA);
                sb.append(SPACE);
            }
        }
        sb.append(RIGHT_BRACKET);
        return sb.toString();
    }

    protected static String generateUpdateList(ArrayList<String> columns, ArrayList<String> values) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < columns.size(); i++) {
            sb.append(columns.get(i));
            sb.append(EQUALS);
            sb.append(APOSTROPHE);
            sb.append(values.get(i));
            sb.append(APOSTROPHE);
            if (i < (columns.size()-1)) {
                sb.append(COMMA);
                sb.append(SPACE);
            }
        }
        return sb.toString();
    }

    public String getStatement() {
        return statement;
    }

}