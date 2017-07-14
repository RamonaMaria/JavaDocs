package ro.teamnet.zth.appl.domain.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Location;

/**
 * Created by Ramona.Raducu on 7/14/2017.
 */
public
class LocationDao {


    public
    LocationDao(EntityManager e) {
        this.e = new EntityManagerImpl();
    }

    EntityManager e;

    public
    Location findById(Class entityClass, Long id) throws SQLException {
        return (Location) e.findById(entityClass, id);
    }

    public
    <Location> Object insert(Location entity) {
        return (Location) e.insert(entity);
    }


    public
    List<Location> findAll(Class entityClass) {
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
