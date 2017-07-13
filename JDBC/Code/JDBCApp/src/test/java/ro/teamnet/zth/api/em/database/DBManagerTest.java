package ro.teamnet.zth.api.em.database;

import org.junit.Test;
import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Ramona.Raducu on 7/13/2017.
 */
public class DBManagerTest {

    @Test
    public void testGetConnection() {
        Connection connection = DBManager.getConnection();
        assertNotNull(connection);
    }

    @Test
    public void testCheckConnection() {
        Connection connection = DBManager.getConnection();
        int r = 0;
        try {
           r = DBManager.checkConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals(1, r);
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getNextIdVal() throws SQLException {
        Connection connection = DBManager.getConnection();
        EntityManagerImpl e = new EntityManagerImpl();
        assertEquals(24001, e.getNextIdVal("EMPLOYEES","salary"));
    }

    @Test
    public void testfindById() {
        Connection connection = DBManager.getConnection();
        EntityManagerImpl e = new EntityManagerImpl();
        try {
          assertEquals("Administration",e.findById(Department.class, (long)10).getDepartmentName());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }


}
