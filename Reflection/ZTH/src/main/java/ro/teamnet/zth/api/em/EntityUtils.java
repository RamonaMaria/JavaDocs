package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramona.Raducu on 7/12/2017.
 */
public class EntityUtils {
    private EntityUtils() {
        throw  new UnsupportedOperationException();
    }

    public static String getTableName(Class entity) {
       return ((Table)entity.getAnnotation(Table.class)).name();
    }

    public static List getColumns(Class entity) {
        Field[] fields = entity.getDeclaredFields();
        List columnInfoList = new ArrayList<String>();

        for (int i = 0; i < fields.length; i++) {
            ColumnInfo c = new ColumnInfo();
            if(fields[i].isAnnotationPresent(Column.class)) {
               c.setDbColumnName(fields[i].getAnnotation(Column.class).name());
               c.setColumnType(fields[i].getType());
               c.setColumnName(fields[i].getName());
               c.setId(false);
            }
            if (fields[i].isAnnotationPresent(Id.class)) {
                c.setDbColumnName(fields[i].getAnnotation(Column.class).name());
                c.setColumnType(fields[i].getType());
                c.setColumnName(fields[i].getName());
                c.setId(true);
            }
            if (c != null)
                columnInfoList.add(c);
        }
        return columnInfoList;

    }

    public static Object castFromSqlType (Object value, Class wantedType) {

        if (value == null) {
            return value;
        }
        if (value instanceof BigDecimal) {
            BigDecimal b = (BigDecimal)value;
            if (wantedType.getClass().equals(Integer.TYPE)) {
                return b.intValue();
            }

           if (wantedType.getClass().equals(Long.TYPE)) {
                return b.longValue();
            }

            if (wantedType.getClass().equals(Float.TYPE)) {
                return b.floatValue();
            }
            if (wantedType.getClass().equals(Double.TYPE)) {
                return b.doubleValue();
            }
        }
    return  value;
    }

    public static  List<Field> getFieldsByAnnotations(Class clazz, Class annotation) {
        Field[] fields = clazz.getDeclaredFields();

        List l = new ArrayList<Field>();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].isAnnotationPresent(annotation)) {
                l.add(fields[i].getName());
            }
        }
        return l;
    }

    public static Object getSqlValue(Object object) {
        if (object.getClass().isAnnotationPresent(Table.class)) {
            Field[] fields = object.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                if (fields[i].isAnnotationPresent(Id.class)) {
                   fields[i].setAccessible(true);
                   return fields[i];
                }
            }
        }
        return object;
    }
}
