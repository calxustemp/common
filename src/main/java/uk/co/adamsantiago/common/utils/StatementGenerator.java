package io.adamgomez.common.utils;

import java.util.ArrayList;

public class StatementGenerator {

    public static String insert(String table, ArrayList<String> columns, ArrayList<String> values) {
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO ");
        sb.append(table);
        generateList(sb, columns);
        sb.append(" VALUES");
        generateList(sb, values);
        sb.append(";");
        return sb.toString();
    }

    private static StringBuffer generateList(StringBuffer sb, ArrayList<String> items) {
        sb.append(" (");
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i));
            if (i != (items.size()-1)) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb;
    }

    public static String select(ArrayList<String> columns, String table, ArrayList<String> conditions) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT ");
        for(int i = 0; i < columns.size(); i++) {
            sb.append(columns.get(i));
            if (i < (columns.size()-1)) {
                sb.append(", ");
            }
        }
        sb.append(" FROM ");
        sb.append(table);
        if (conditions.size() > 0) {
            sb.append(" WHERE ");
            for(int i = 0; i < conditions.size(); i++) {
                sb.append(conditions.get(i));
                if (i < (conditions.size()-1)) {
                    sb.append(" AND ");
                }
            }
        }
        sb.append(";");
        return sb.toString();
    }

    public static String join(String table, String existingQuery, ArrayList<String> conditions) {
        existingQuery = existingQuery.substring(0, existingQuery.length()-1);
        StringBuffer sb = new StringBuffer(existingQuery);
        sb.append(" JOIN ");
        sb.append(table);
        sb.append(" WHERE ");
        for(int i = 0; i < conditions.size(); i++) {
            sb.append(conditions.get(i));
            if (i < (conditions.size()-1)) {
                sb.append(" AND ");
            }
        }
        sb.append(";");
        return sb.toString();
    }

    public static String update(String table, ArrayList<String> set, ArrayList<String> conditions) {
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE ");
        sb.append(table);
        sb.append(" SET ");
        for(int i = 0; i < set.size(); i++) {
            sb.append(set.get(i));
            if (i < (set.size()-1)) {
                sb.append(", ");
            }
        }
        sb.append(" WHERE ");
        for(int i = 0; i < conditions.size(); i++) {
            sb.append(conditions.get(i));
            if (i < (conditions.size()-1)) {
                sb.append(" AND ");
            }
        }
        sb.append(";");
        return sb.toString();
    }
}
