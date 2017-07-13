package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.Department;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ro.teamnet.zth.api.em.EntityUtils.getColumns;

/**
 * Created by Ramona.Raducu on 7/13/2017.
 */
public class EntityManagerImpl implements EntityManager {
    @Override
    public <T> T findById(Class<T> entityClass, Long id) throws SQLException {

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
                        f.set(t, EntityUtils.castFromSqlType(rs.getObject(columnInfos.get(i).getDbColumnName()),f.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(t.toString());
            return t;
        }
        return null;
    }



    @Override
    public <T> Object insert(T entity) {
        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columnInfos = getColumns(entity.getClass());
        long aux = -1;

        for (int i = 0; i < columnInfos.size(); i++) {
            if(columnInfos.get(i).isId() == true) {
               aux = getNextIdVal(tableName, columnInfos.get(i).getDbColumnName());
               columnInfos.get(i).setValue(aux);
            } else {
                try {
                    Field f =  entity.getClass().getDeclaredField(columnInfos.get(i).getColumnName());
                    f.setAccessible(true);
                    try {
                        columnInfos.get(i).setValue(f.get(entity));
                    } catch (IllegalAccessException e) {
                        System.out.println("0");

                        e.printStackTrace();
                    }
                } catch (NoSuchFieldException e) {
                    System.out.println("1");

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
            System.out.println("2");

            e.printStackTrace();
        }
        ;

        String query = objectB.createQuery();
        try {
            pst.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("3");
            e.printStackTrace();
        }

        try {
           return findById(entity.getClass(), aux);
        } catch (SQLException e) {
            System.out.println("4");
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        EntityManagerImpl e = new EntityManagerImpl();

        Department d = new Department();
        d.setDepartmentName("aaaaaaaaaaa");
        d.setLocation((long)1700);
        e.insert(d);
        System.out.println( e.findAll(Department.class).size());

    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columnInfos = getColumns(entityClass);
        QueryBuilder objectB = new QueryBuilder();
        objectB.setTableName(tableName);
        objectB.addQueryColumns(columnInfos);
        objectB.setQueryType(QueryType.SELECT);
        ArrayList<T> arrayList = new ArrayList<T>();
        String query = objectB.createQuery();
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
                            f.set(t, EntityUtils.castFromSqlType(rs.getObject(columnInfos.get(i).getDbColumnName()),f.getType()));
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
    public long getNextIdVal(String tableName, String columnIdName){
        String sqlIdentifier =  "SELECT MAX("+ columnIdName + ") FROM " + tableName;
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
                    id = rs.getLong(1)+ 1;
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
}
