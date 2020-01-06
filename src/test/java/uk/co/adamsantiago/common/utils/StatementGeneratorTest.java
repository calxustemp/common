import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import uk.co.adamsantiago.common.utils.StatementGenerator;

public class StatementGeneratorTest {

    String table;
    ArrayList<String> columns;
    ArrayList<String> values;

    public void prepareInsert() {
        table = "user";
        columns = new ArrayList<String>();
        values = new ArrayList<String>();

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
        prepareInsert();
        String expectedInsertStatement = "INSERT INTO user (first_name, last_name, email, password) VALUES (Gordon, Adam, gordon.adam@hotmail.co.uk, 5f4dcc3b5aa765d61d8327deb882cf99);";
        String insertStatement = StatementGenerator.insert(table, columns, values);
        assertEquals(expectedInsertStatement, insertStatement);
    }
}