package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ro.teamnet.zth.api.em.EntityUtils.getColumns;

/**
 * Created by Ramona.Raducu on 7/13/2017.
 */
public
class EntityManagerImpl implements EntityManager {
    @Override
    public
    <T> T findById(Class<T> entityClass, Long id) throws SQLException {

        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columnInfos = getColumns(entityClass);
        List<Field> fields = EntityUtils.getFieldsByAnnotations(entityClass, Id.class);
        List<Field> fieldsColumn = EntityUtils.getFieldsByAnnotations(entityClass, Column.class);
        Condition objectCond = new Condition();
        for (ColumnInfo c : columnInfos) {
            if (c.isId()) {
                objectCond.setColumnName(c.getDbColumnName());
            }
        }

        objectCond.setValue(id);

        QueryBuilder objectB = new QueryBuilder();
        objectB.setTableName(tableName);
        objectB.addQueryColumns(columnInfos);
        objectB.setQueryType(QueryType.SELECT);
        objectB.addCondition(objectCond);
        String query = objectB.createQuery();
        Statement pst = connection.createStatement();
        ResultSet rs = pst.executeQuery(query);

        while (rs.next()) {
            T t = null;
            try {
                t = entityClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < columnInfos.size(); i++) {
                try {
                    Field f = t.getClass().getDeclaredField(columnInfos.get(i).getColumnName());
                    f.setAccessible(true);
                    try {
                        f.set(t, EntityUtils.castFromSqlType(rs.getObject(columnInfos.get(i).getDbColumnName()), f.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            // System.out.println(t.toString());
            return t;
        }
        return null;
    }


    @Override
    public
    <T> Object insert(T entity) {
        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columnInfos = getColumns(entity.getClass());
        long aux = -1;

        for (int i = 0; i < columnInfos.size(); i++) {
            if (columnInfos.get(i).isId() == true) {
                aux = getNextIdVal(tableName, columnInfos.get(i).getDbColumnName());
                columnInfos.get(i).setValue(aux);
            } else {
                try {
                    Field f = entity.getClass().getDeclaredField(columnInfos.get(i).getColumnName());
                    f.setAccessible(true);
                    try {
                        columnInfos.get(i).setValue(f.get(entity));
                    } catch (IllegalAccessException e) {

                        e.printStackTrace();
                    }
                } catch (NoSuchFieldException e) {

                    e.printStackTrace();
                }
            }
        }

        QueryBuilder objectB = new QueryBuilder();
        objectB.setTableName(tableName);
        objectB.addQueryColumns(columnInfos);
        objectB.setQueryType(QueryType.INSERT);
        Statement pst = null;
        try {
            pst = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ;

        String query = objectB.createQuery();
        try {
            pst.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            return findById(entity.getClass(), aux);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public
    <T> List<T> findAll(Class<T> entityClass) {
        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columnInfos = getColumns(entityClass);
        QueryBuilder objectB = new QueryBuilder();
        objectB.setTableName(tableName);
        objectB.addQueryColumns(columnInfos);
        objectB.setQueryType(QueryType.SELECT);
        String query = objectB.createQuery();
        ArrayList<T> arrayList = new ArrayList<T>();

        Statement pst = null;
        try {
            pst = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = pst.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {
                T t = null;
                try {
                    t = entityClass.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < columnInfos.size(); i++) {
                    Field f = null;
                    try {
                        f = t.getClass().getDeclaredField(columnInfos.get(i).getColumnName());

                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                    f.setAccessible(true);
                    try {
                        try {
                            f.set(t, EntityUtils.castFromSqlType(rs.getObject(columnInfos.get(i).getDbColumnName()), f.getType()));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                arrayList.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }


    @Override
    public
    long getNextIdVal(String tableName, String columnIdName) {
        String sqlIdentifier = "SELECT MAX(" + columnIdName + ") FROM " + tableName;
        Connection connection = DBManager.getConnection();
        Statement pst = null;
        try {
            pst = connection.createStatement();
        } catch (SQLException e) {
            //  System.out.println("1");
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = pst.executeQuery(sqlIdentifier);
        } catch (SQLException e) {
            //System.out.println("2");
            e.printStackTrace();
        }
        long id = -1;

        try {
            while (rs.next()) {
                try {
                    id = rs.getLong(1) + 1;
                } catch (SQLException e) {
                    //    System.out.println("3");
                    e.printStackTrace();
                }
                System.out.println(id);
            }
        } catch (SQLException e) {
            // System.out.println("4");
            e.printStackTrace();
        }

        return id;
    }

    @Override
    public
    <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params) {
        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columnInfos = getColumns(entityClass);
        List<T> list = new ArrayList<T>();
        Condition objectCond = null;
        QueryBuilder objectB = new QueryBuilder();
        objectB.setTableName(tableName);
        objectB.addQueryColumns(columnInfos);
        objectB.setQueryType(QueryType.SELECT);


        long id = -1;
        String nameCol = null;

        for (int i = 0; i < columnInfos.size(); i++) {
            if (params.containsKey(columnInfos.get(i).getDbColumnName())) {
                objectCond = new Condition();
                objectCond.setColumnName(columnInfos.get(i).getDbColumnName());
                objectCond.setValue(params.get(columnInfos.get(i).getDbColumnName()));
                objectB.addCondition(objectCond);
            }
        }


        String query = objectB.createQuery();

        Statement s = null;
        ResultSet rs = null;
        try {
            s = connection.createStatement();
            rs = s.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                T t = null;
                try {
                    t = entityClass.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < columnInfos.size(); i++) {
                    Field f = null;
                    try {
                        f = t.getClass().getDeclaredField(columnInfos.get(i).getColumnName());

                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                    f.setAccessible(true);
                    try {
                        try {
                            f.set(t, EntityUtils.castFromSqlType(rs.getObject(columnInfos.get(i).getDbColumnName()), f.getType()));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }

                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;


    }


    @Override
    public
    void delete(Object entity) {
        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columnInfos = getColumns(entity.getClass());
        Condition objectCond = new Condition();

        long id = -1;
        String nameCol = null;

        for (int i = 0; i < columnInfos.size(); i++) {
            try {
                Field f = entity.getClass().getDeclaredField(columnInfos.get(i).getColumnName());
                f.setAccessible(true);
                try {
                    columnInfos.get(i).setValue(f.get(entity));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            if (columnInfos.get(i).isId()) {

                if (columnInfos.get(i) == null) {
                    return;
                } else {
                    id = (long) columnInfos.get(i).getValue();
                    objectCond.setValue(id);
                    nameCol = columnInfos.get(i).getDbColumnName();
                    objectCond.setColumnName(nameCol);
                }
            }
        }

        QueryBuilder objectB = new QueryBuilder();
        objectB.setTableName(tableName);
        objectB.addQueryColumns(columnInfos);
        objectB.addCondition(objectCond);
        objectB.setQueryType(QueryType.DELETE);


        String query = objectB.createQuery();

        Statement s = null;

        try {
            s = connection.createStatement();
            s.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public
    <T> T update(T entity) {

        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columnInfos = getColumns(entity.getClass());
        Condition objectCond = new Condition();

        long id = -1;
        String nameCol = null;

        for (int i = 0; i < columnInfos.size(); i++) {
            try {
                Field f = entity.getClass().getDeclaredField(columnInfos.get(i).getColumnName());
                f.setAccessible(true);
                try {
                    columnInfos.get(i).setValue(f.get(entity));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            if (columnInfos.get(i).isId()) {

                if (columnInfos.get(i) == null) {
                    return null;
                } else {
                    id = (long) columnInfos.get(i).getValue();
                    objectCond.setValue(id);
                    nameCol = columnInfos.get(i).getDbColumnName();
                    objectCond.setColumnName(nameCol);
                }
            }
        }

        QueryBuilder objectB = new QueryBuilder();
        objectB.setTableName(tableName);
        objectB.addQueryColumns(columnInfos);
        objectB.addCondition(objectCond);
        objectB.setQueryType(QueryType.UPDATE);


        String query = objectB.createQuery();

        Statement s = null;
        try {
            s = connection.createStatement();
            s.executeQuery(query);
            return (T) findById(entity.getClass(), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static
    void main(String[] args) {
        EntityManagerImpl e = new EntityManagerImpl();

        Department d = new Department();
        d.setDepartmentName("Marketing");
        d.setId((long) 280);
        d.setLocation((long) 1800);
        //   e.delete(d);
        // System.out.println( e.findAll(Department.class).size());
        Map<String, Object> h = new HashMap<String, Object>();
        Location l = new Location();
        l.setCity("Bucuresti");
        l.setPostalCode("11");
        l.setStateProvince("buc");
        l.setStreetAddress("dfghj");
        e.insert(l);
        Location l1 = new Location();
        l1.setCity("Bucuresti");
        l1.setPostalCode("11");
        l1.setStateProvince("buc");
        l1.setStreetAddress("jmdfghj");
        e.insert(l1);
        h.put("city", "Southlake");
        h.put("state_province", "Texas");
        System.out.println(e.findByParams(Location.class, h));
    }
}
