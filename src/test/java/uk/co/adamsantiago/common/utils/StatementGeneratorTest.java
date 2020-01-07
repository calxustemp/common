import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import uk.co.adamsantiago.common.utils.StatementGenerator;

public class StatementGeneratorTest {

    public void prepareColumnsAndValues(ArrayList<String> columns, ArrayList<String> values) {
        columns.add("first_name");
        columns.add("last_name");
        columns.add("email");
        columns.add("password");

        values.add("Gordon");
        values.add("Adam");
        values.add("gordon.adam@hotmail.co.uk");
        values.add("5f4dcc3b5aa765d61d8327deb882cf99");
    }
    
    @Test
    public void testInsert() { 
        String table = "user";;
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<String> values = new ArrayList<String>();

        prepareColumnsAndValues(columns, values);

        String expectedInsertStatement = "INSERT INTO user (first_name, last_name, email, password) VALUES (Gordon, Adam, gordon.adam@hotmail.co.uk, 5f4dcc3b5aa765d61d8327deb882cf99);";
        String insertStatement = StatementGenerator.insert(table, columns, values);
        
        assertEquals(expectedInsertStatement, insertStatement);
    }

    @Test
    public void testDelete() {
        String table = "user";
        String column = "id";
        String value = "1";

        String expectedDeleteStatement = "DELETE FROM user WHERE id=1;";
        String deleteStatement = StatementGenerator.delete(table, column, value);

        assertEquals(expectedDeleteStatement, deleteStatement);
    }

    @Test
    public void testUpdate() {
        String table = "user";
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<String> values = new ArrayList<String>();

        prepareColumnsAndValues(columns, values);

        String conditionColumn = "id";
        String conditionValue = "1";

        String expectedUpdateStatement = "UPDATE user SET first_name='Gordon', last_name='Adam', email='gordon.adam@hotmail.co.uk', password='5f4dcc3b5aa765d61d8327deb882cf99' WHERE id=1;";
        String updateStatement = StatementGenerator.update(table, columns, values, conditionColumn, conditionValue);

        assertEquals(expectedUpdateStatement, updateStatement);
    }
}