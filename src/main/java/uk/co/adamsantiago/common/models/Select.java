package uk.co.adamsantiago.common.models;

import uk.co.adamsantiago.common.models.Statement;

import java.util.ArrayList;

public class Select extends Statement {

    public Select(ArrayList<String> columns, String table, ArrayList<String> conditionColumns, ArrayList<String> conditionValues) {
        super();
        StringBuffer sb = new StringBuffer();
        sb.append(SELECT);
        sb.append(SPACE);
        sb.append(generateSelectColumnsList(columns));
        sb.append(SPACE);
        sb.append(FROM);
        sb.append(SPACE);
        sb.append(table);
        if (!conditionColumns.isEmpty()) {
            sb.append(SPACE);
            sb.append(WHERE);
            sb.append(SPACE);
            sb.append(generateSelectConditionsList(conditionColumns, conditionValues));
        }
        sb.append(SEMICOLON);
        statement = sb.toString();
    }

    
}