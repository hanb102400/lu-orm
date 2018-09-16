package com.rats.orm.utils;

import com.rats.orm.annotation.SafeDelete;
import org.springframework.util.ReflectionUtils;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SqlUtils {


    public static <T> String buildQuerySql(Class<T> elementType, Map<String, Object> params, Map<String, Object> conditions, Map<String, Object> orders, String extConditionSql ){

        String sqlString = "";
        if (elementType.getClass().isAnnotationPresent(Table.class)) {
            Annotation tableAnnotation = elementType.getClass().getAnnotation(Table.class);
            String tableName = (String)ReflectionUtils.invokeMethod(ReflectionUtils.findMethod(Table.class, "value"), tableAnnotation);

            if (paramMap != null && !paramMap.isEmpty()) {
                tableName = tableName.toUpperCase();
                String insertSql = "";
                String columnSql = "INSERT INTO " + tableName + "(";
                String valuesSql = " VALUES(";
                String[] var6 = tableColumns;
                int var7 = tableColumns.length;

                for(int var8 = 0; var8 < var7; ++var8) {
                    String column = var6[var8];
                    String columnUpper = column.toUpperCase();
                    columnSql = columnSql + columnUpper.substring(0, columnUpper.length()) + ",";
                    valuesSql = valuesSql + ":" + columnUpper + ",";
                }

                columnSql = columnSql.substring(0, columnSql.length() - 1) + ")";
                valuesSql = valuesSql.substring(0, valuesSql.length() - 1) + ")";
                insertSql = columnSql + valuesSql;
                return insertSql;
            } else {
                throw new RuntimeException("参数不能为空!");
            }

            return sqlString;
        } else {
            throw new Exception("can't find class" + elementType.getClass().getName() + " table annotation,please config!");
        }
    }

    private static <T>  String[] getQueryColumns(Class<T> elementType,Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        List<String> columnList = new ArrayList();
        for(int i = 0; i  < fields.length; i++) {
            Field field = fields[i];
            if (field.isAnnotationPresent( Column.class)) {
                Annotation annotation = field.getAnnotation(Column.class);
                String columnName = (String)ReflectionUtils.invokeMethod(ReflectionUtils.findMethod(Column.class, "value"), annotation);
                if( elementType.getClass().isAnnotationPresent(SafeDelete.class) );{
                    SafeDelete safeDeleteAnno = elementType.getClass().getAnnotation(SafeDelete.class);
                    if(safeDeleteAnno.name().equals( columnName)) {
                        continue;
                    }
                }
                if( field.isAnnotationPresent( Transient.class))  {
                    continue;
                }
                columnList.add(columnName);
            }
        }
        return columnList.toArray(new String[columnList.size()]);
    }

    private static String getQuerySql(String tableName, String[] tableColumns, Map<String, Object> paramMap) {
        if (paramMap != null && !paramMap.isEmpty()) {
            tableName = tableName.toUpperCase();
            String insertSql = "";
            String columnSql = "INSERT INTO " + tableName + "(";
            String valuesSql = " VALUES(";
            String[] var6 = tableColumns;
            int var7 = tableColumns.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                String column = var6[var8];
                String columnUpper = column.toUpperCase();
                columnSql = columnSql + columnUpper.substring(0, columnUpper.length()) + ",";
                valuesSql = valuesSql + ":" + columnUpper + ",";
            }

            columnSql = columnSql.substring(0, columnSql.length() - 1) + ")";
            valuesSql = valuesSql.substring(0, valuesSql.length() - 1) + ")";
            insertSql = columnSql + valuesSql;
            return insertSql;
        } else {
            throw new RuntimeException("参数不能为空!");
        }
    }
}
