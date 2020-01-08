package uk.co.adamsantiago.common.utils;

import uk.co.adamsantiago.common.models.Insert;
import uk.co.adamsantiago.common.models.Delete;
import uk.co.adamsantiago.common.models.Update;
import uk.co.adamsantiago.common.models.Select;

import java.util.ArrayList;

public class StatementGenerator {

    public static String insert(String table, ArrayList<String> columns, ArrayList<String> values) {
        Insert insert = new Insert(table, columns, values);
        return insert.getStatement();
    }

    public static String delete(String table, String column, String value) {
        Delete delete = new Delete(table, column, value);
        return delete.getStatement();
    }

    public static String update(String table, ArrayList<String> columns, ArrayList<String> values, String conditionColumn, String conditionValue) {
        Update update = new Update(table, columns, values, conditionColumn, conditionValue);
        return update.getStatement();
    }

    public static String select(ArrayList<String> columns, String table, ArrayList<String> conditionColumns, ArrayList<String> conditionValues) {
        Select select = new Select(columns, table, conditionColumns, conditionValues);
        return select.getStatement();
    }
}
