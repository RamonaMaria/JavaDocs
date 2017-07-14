package ro.teamnet.zth.appl.domain.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Ramona.Raducu on 7/14/2017.
 */
public
class DepartmentDao {
    EntityManager e;

    public
    DepartmentDao() {
    }

    public
    DepartmentDao(EntityManager e) {
        this.e = new EntityManagerImpl();
    }

    public
    Department findById(Class entityClass, Long id) throws SQLException {
        return (Department) e.findById(entityClass, id);
    }


    public
    <Department> Object insert(Department entity) {
        return (Department) e.insert(entity);
    }


    public
    List<Department> findAll(Class entityClass) {
        return e.findAll(entityClass);
    }

    public
    long getNextIdVal(String tableName, String columnIdName) throws SQLException {
        return e.getNextIdVal(tableName, columnIdName);
    }


    public
    void delete(Object entity) {
        e.delete(entity);
    }
}
