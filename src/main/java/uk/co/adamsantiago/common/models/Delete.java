package uk.co.adamsantiago.common.models;

import uk.co.adamsantiago.common.models.Statement;

import java.util.ArrayList;

public class Delete extends Statement {

    public Delete(String table, String column, String value) {
        super();
        StringBuffer sb = new StringBuffer();
        sb.append(DELETE);
        sb.append(SPACE);
        sb.append(FROM);
        sb.append(SPACE);
        sb.append(table);
        sb.append(SPACE);
        sb.append(WHERE);
        sb.append(SPACE);
        sb.append(column);
        sb.append(EQUALS);
        sb.append(value);
        sb.append(SEMICOLON);
        statement = sb.toString();
    }

    
}