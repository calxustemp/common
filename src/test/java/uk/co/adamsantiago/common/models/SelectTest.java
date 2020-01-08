import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import uk.co.adamsantiago.common.models.Select;

public class SelectTest {

    public void prepareColumnsAndValues(ArrayList<String> columns, ArrayList<String> conditionColumns, ArrayList<String> conditionValues) {
        columns.add("first_name");
        columns.add("last_name");
        
        conditionColumns.add("id");
        conditionColumns.add("email");

        conditionValues.add("1");
        conditionValues.add("gtadam@protonmail.ch");
    }

    @Test
    public void testSelect() {
        String table = "user";
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<String> conditionColumns = new ArrayList<String>();
        ArrayList<String> conditionValues = new ArrayList<String>();

        prepareColumnsAndValues(columns, conditionColumns, conditionValues);

        String expectedSelectStatement = "SELECT first_name, last_name FROM user WHERE id=1 AND email=gtadam@protonmail.ch;";
        Select select = new Select(columns, table, conditionColumns, conditionValues);
        String selectStatement = select.getStatement();

        assertEquals(expectedSelectStatement, selectStatement);
    }

}