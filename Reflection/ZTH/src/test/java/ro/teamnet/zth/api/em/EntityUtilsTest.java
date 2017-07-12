package ro.teamnet.zth.api.em;

import ro.teamnet.zth.appl.domain.Departament;
import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

import java.util.List;

/**
 * Created by Ramona.Raducu on 7/12/2017.
 */
public class EntityUtilsTest {
    @Test
    public void testGetTableNameMethod() {
        String tableName = EntityUtils.getTableName(Departament.class);
        assertEquals("Table name should be departments!", "DEPARTMENTS", tableName);

    }
//    @Test
//    public void testGetColumnNameMethod() {
//        List tableName = EntityUtils.getColumns(Departament.class);
//        for (int i = 0; i < tableName.size(); i++) {
//            assertEquals("Table name should be departments!", "DEPARTMENT_ID", tableName.get(i));
//        }
//
//
//    }
}
