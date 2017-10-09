//#################################################
//When instantiated this class creates connection.
//It is your responsibility to CLOSE this connection
// in appropriate way.
//#################################################

package entitymanager;

import connection.ConnectionManager;
import persistence.Column;
import persistence.Entity;
import persistence.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;


public class EntityManager implements DBContext {
    private Connection conn;

    public EntityManager() throws SQLException {
        conn = ConnectionManager.getConnection();
    }

    @Override
    public <E> boolean persist(E entity) throws IllegalAccessException, SQLException, NoSuchFieldException {
        createTableIfNotExists(entity);

        Field primaryKey = entity.getClass().getDeclaredField("id");
        primaryKey.setAccessible(true);
        Object value = primaryKey.get(entity);
        if (value == null || (Long) value <= 0) {
            insert(entity, primaryKey);
        } else {
            update(entity, primaryKey);
        }


        return true;
    }

    private <E> void update(E entity, Field primaryKey) throws IllegalAccessException, SQLException {
        String tableName = tableName(entity);
        String updateQuery = "UPDATE " + tableName + " SET ";
        String where = " WHERE ";

        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            String cName = columnName(field);
            Object fValue = field.get(entity);

            String valueStr = "";
            if (fValue instanceof Number) {
                valueStr = fValue + " ";
            } else {
                valueStr = "'" + fValue + "'";
            }

            if (isPrimaryKey(field)) {
                where += cName + " = " + valueStr;
                continue;
            }

            updateQuery += cName + " = " + valueStr;
            if (i < fields.length - 1) {
                updateQuery += ", ";
            }
        }

        updateQuery += where;

        try (PreparedStatement stmt = conn.prepareStatement(updateQuery)) {
            stmt.execute();
        }
    }

    private <E> void insert(E entity, Field primaryKey) throws IllegalAccessException, SQLException {
        String tableName = tableName(entity);
        String sqlInsertQuery = "INSERT INTO " + tableName + " (";

        String columns = "";
        String values = "";

        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            if (!isPrimaryKey(field)) {
                columns += columnName(field);

                Object value = field.get(entity);

                values += "'" + value + "'";

                if (i < fields.length - 1) {
                    columns += ", ";
                    values += ", ";
                }

            }


        }

        sqlInsertQuery += columns + ")" + "VALUES (" + values + ")";

        try (PreparedStatement stmt = conn.prepareStatement(sqlInsertQuery)) {
            stmt.execute();
        }
    }

    private <E> boolean createTableIfNotExists(E entity) throws IllegalAccessException, SQLException {
        checkPrimaryKey(entity);
        String tableName = tableName(entity);
        String createTableQuery = "CREATE TABLE IF NT EXISTS " + tableName + "(";
        Field[] fields = entity.getClass().getDeclaredFields();
        String columns = "";
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            String columnName = columnName(field);
            if (isPrimaryKey(field)) {
                columns += columnName + " " + type(field, entity) + " AUTO_INCREMENT PRIMARY KEY";
            }else{
                columns += columnName + " " + type(field, entity);
            }
            if (i < fields.length - 1) {
                columns += ", ";
            }
        }

        createTableQuery += columns + ")";

        try (PreparedStatement stmt = conn.prepareStatement(createTableQuery)) {
            return stmt.execute();
        }
    }

    private String type(Field field, Object entity) throws IllegalAccessException {
        Object value = field.get(entity);
        if (value instanceof Integer) {
            return "INT";
        }

        if (value instanceof Long) {
            return "BIGINT";
        }

        if (value instanceof String) {
            return "VARCHAR(50)";
        }

        if (value instanceof LocalDate) {
            return "DATE)";
        }
        return null;
    }

    private <E> String tableName(E entity){
        String tableName = "";
        Entity entityAnnotation = entity.getClass().getAnnotation(Entity.class);
        if(entityAnnotation != null){
            tableName = entityAnnotation.name();
        }
        if(tableName.isEmpty()){
            tableName = entity.getClass().getSimpleName().toLowerCase();
        }
        return tableName;
    }

    private String columnName(Field field){
        String columnName = "";
        Column columnAnnotation = field.getAnnotation(Column.class);
        if(columnAnnotation!=null){
            columnName = columnAnnotation.name();
        }

        if(columnName.isEmpty()){
            columnName = field.getName();
        }
        return columnName;
    }
    private boolean isPrimaryKey(Field field){
        Id idAnnotation = field.getAnnotation(Id.class);
        return idAnnotation != null;
    }

    private <E> void checkPrimaryKey(E entity){
       long idCount =  Arrays.stream(entity.getClass().getDeclaredFields())
        .filter(f->f.isAnnotationPresent(Id.class))
        .count();
       if(idCount!=1){
           throw new IllegalStateException("Entity should have single primary key field");
       }
    }


    @Override
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            //log here
        }
    }
}
