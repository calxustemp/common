package uk.co.adamsantiago.common.utils;

import uk.co.adamsantiago.common.models.Insert;
import uk.co.adamsantiago.common.models.Delete;
import uk.co.adamsantiago.common.models.Update;
import uk.co.adamsantiago.common.models.Select;

import org.apache.log4j.Logger;
import java.util.ArrayList;

public class StatementGenerator {

    final static Logger logger = Logger.getLogger(StatementGenerator.class);

    public static String insert(String table, ArrayList<String> columns, ArrayList<String> values) {
        Insert insert = new Insert(table, columns, values);
        logger.debug("Generated statement: " + insert.getStatement());
        return insert.getStatement();
    }

    public static String delete(String table, String column, String value) {
        Delete delete = new Delete(table, column, value);
        logger.debug("Generated statement: " + delete.getStatement());
        return delete.getStatement();
    }

    public static String update(String table, ArrayList<String> columns, ArrayList<String> values, String conditionColumn, String conditionValue) {
        Update update = new Update(table, columns, values, conditionColumn, conditionValue);
        logger.debug("Generated statement: " + update.getStatement());
        return update.getStatement();
    }

    public static String select(ArrayList<String> columns, String table, ArrayList<String> conditionColumns, ArrayList<String> conditionValues) {
        Select select = new Select(columns, table, conditionColumns, conditionValues);
        logger.debug("Generated statement: " + select.getStatement());
        return select.getStatement();
    }
}
