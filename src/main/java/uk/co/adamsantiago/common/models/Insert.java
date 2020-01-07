package uk.co.adamsantiago.common.models;

import uk.co.adamsantiago.common.models.Statement;

import java.util.ArrayList;

public class Insert extends Statement {

    public Insert(String table, ArrayList<String> columns, ArrayList<String> values) {
        super();
        StringBuffer sb = new StringBuffer();
        sb.append(INSERT_INTO);
        sb.append(SPACE);
        sb.append(table);
        sb.append(SPACE);
        sb.append(generateList(columns));
        sb.append(SPACE);
        sb.append(VALUES);
        sb.append(SPACE);
        sb.append(generateList(values));
        sb.append(SEMICOLON);
        statement = sb.toString();
    }

    
}