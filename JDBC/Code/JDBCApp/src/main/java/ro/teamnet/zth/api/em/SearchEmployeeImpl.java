package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.dao.Employee;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static ro.teamnet.zth.api.em.EntityUtils.getColumns;

/**
 * Created by Ramona.Raducu on 7/14/2017.
 */
public
class SearchEmployeeImpl implements SearchEmployee {
    @Override
    public
    List<Employee> findEmployee(String department) {

        Connection connection = DBManager.getConnection();
        List<ColumnInfo> columnInfos = EntityUtils.getColumns(Employee.class);

        String query = "select employees.* from employees  inner join departments on employees.department_id=departments.department_id " +
                " where lower(departments.DEPARTMENT_NAME) like " +
                "lower('%"  + department + "%')";
        List<Employee> list  = new ArrayList<Employee>();

        Statement pst = null;
        try {
            pst = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("1");
            e.printStackTrace();
        }
        ResultSet rs = null;
        System.out.println(query);
        try {
            rs = pst.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("2");
            e.printStackTrace();
        }
        Employee e = null;

        try {
            while (rs.next()) {

                e = new Employee();
                for (ColumnInfo c :columnInfos) {
                    Field f;
                    try {
                        f = e.getClass().getDeclaredField(c.getColumnName());
                        f.setAccessible(true);
                        try {
                            f.set(e, EntityUtils.castFromSqlType(rs.getObject(c.getDbColumnName()), f.getType()));
                        } catch (IllegalAccessException e1) {
                            System.out.println("3");
                            e1.printStackTrace();
                        }
                    } catch (NoSuchFieldException e1) {
                        System.out.println("4");
                        e1.printStackTrace();
                    }
                }
                    list.add(e);
            }
        } catch (SQLException e1) {
            System.out.println("5");
            e1.printStackTrace();
        }

        return list;
    }

    public static
    void main(String[] args) {
        SearchEmployeeImpl s = new SearchEmployeeImpl();
        System.out.println(s.findEmployee("pp"));
    }
}
