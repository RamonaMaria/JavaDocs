package ro.teamnet.zth.api.em;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ramona.Raducu on 7/13/2017.
 */
public interface EntityManager {

    	<T> T findById(Class<T> entityClass, Long id) throws SQLException;
        <T> Object insert(T entity);
        <T> List<T> findAll(Class<T> entityClass);

    abstract <T> long getNextIdVal(String tableName, String columnIdName) throws SQLException;
}
