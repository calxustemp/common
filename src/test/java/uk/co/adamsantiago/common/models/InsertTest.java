import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import uk.co.adamsantiago.common.models.Insert;

public class InsertTest {

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

        String expectedInsertStatement = "INSERT INTO user (`first_name`, `last_name`, `email`, `password`) VALUES ('Gordon', 'Adam', 'gordon.adam@hotmail.co.uk', '5f4dcc3b5aa765d61d8327deb882cf99');";
        Insert insert = new Insert(table, columns, values);
        String insertStatement = insert.getStatement();
        
        assertEquals(expectedInsertStatement, insertStatement);
    }

}