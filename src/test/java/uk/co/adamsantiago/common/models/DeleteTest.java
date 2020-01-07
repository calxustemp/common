import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import uk.co.adamsantiago.common.models.Delete;

public class DeleteTest {

    @Test
    public void testDelete() {
        String table = "user";
        String column = "id";
        String value = "1";

        String expectedDeleteStatement = "DELETE FROM user WHERE id=1;";
        Delete delete = new Delete(table, column, value);
        String deleteStatement = delete.getStatement();

        assertEquals(expectedDeleteStatement, deleteStatement);
    }

}