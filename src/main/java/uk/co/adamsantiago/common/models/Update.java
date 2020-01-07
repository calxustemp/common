package uk.co.adamsantiago.common.models;

import uk.co.adamsantiago.common.models.Statement;

import java.util.ArrayList;

public class Update extends Statement {

    public Update(String table, ArrayList<String> columns, ArrayList<String> values, String conditionColumn, String conditionValue) {
        super();
        StringBuffer sb = new StringBuffer();
        sb.append(UPDATE);
        sb.append(SPACE);
        sb.append(table);
        sb.append(SPACE);
        sb.append(SET);
        sb.append(SPACE);
        sb.append(generateUpdateList(columns, values));
        sb.append(SPACE);
        sb.append(WHERE);
        sb.append(SPACE);
        sb.append(conditionColumn);
        sb.append(EQUALS);
        sb.append(conditionValue);
        sb.append(SEMICOLON);
        statement = sb.toString();
    }

    
}