package cn.stephenchen.study.util.createCode;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库表的相关操作类，包括数据库连接，获取数据表名或列名等等
 */
public class DataTableUtil {

    /**主键对象，在获得表的列数据时赋值*/
    private static PrimaryKey primaryKey ;

    /**
     * 获取数据库连接
     */
    public static Connection getConnection(String url , String name , String password){
        try{
            //装载mysql驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //根据url，账号和密码获取数据库连接
            return DriverManager.getConnection(url,name,password);
        }catch (Exception e){
            System.out.println("====获取连接数据库出错，报告如下：=====");
            e.printStackTrace();
            System.out.println("=====获取连接数据库出错，报告结束。。");
        }
        return null ;
    }


    /**
     * 获取表的所有列数据
     * @param conn 数据库连接
     * @param schema 数据库名
     * @param tableName 表名
     * @return
     * @throws SQLException
     */
    public static List<ColumnData> getColumnDatas(Connection conn , String schema, String tableName) throws SQLException {
        //获取表的字段信息的sql语句
        String SQLColumns = "SELECT distinct COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT, COLUMN_KEY "
                            + "FROM information_schema.columns "
                            + "WHERE table_schema= ? and table_name = ? ; ";
        //构造preparedStatement，并执行查询
        PreparedStatement ps = conn.prepareStatement(SQLColumns);
        ps.setString(1,schema);
        ps.setString(2,tableName);
        ResultSet rs = ps.executeQuery();

        List<ColumnData> columnList = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString(1);
            //表的字段名转换成实体类字段名，即转换成java规范的驼峰式命名法
            //由于表字段名已经是规范的，因此不用转换
            String fieldName = name;
            //表字段的数据类型
            String columnType = rs.getString(2);
            String comment = rs.getString(3);
            //实体类字段类型
            String fieldType = ConvertUtil.columnTypeToFieldType(columnType);
            //第一个字符大写的实体类字段名
            String maxFieldName = ConvertUtil.fieldNameToMaxFieldName(fieldName);
            //获得jdbcType
            String jdbcType = ConvertUtil.columnTypeToJdbcType(columnType);
            //获得主键列
            String key = rs.getString(4).toUpperCase();
            ColumnData cd = new ColumnData();
            if (key != null && key.contains("PRI")) {
                primaryKey = new PrimaryKey();
                primaryKey.setKeyFieldName(fieldName);
                primaryKey.setKeyName(name);
                primaryKey.setKeySqlType(jdbcType);
                //表字段数据类型转换为全名的Java数据类型
                primaryKey.setKeyJavaType(ConvertUtil.columnTypeToFullJavaType(columnType));

                cd.setIsPK(name);
            }
            //jdbc类型
            cd.setJdbcType(jdbcType);
            //表 列名
            cd.setColumnName(name);
            //实体 字段名
            cd.setFieldName(fieldName);
            //实体类 字段类型
            cd.setDataType(fieldType);
            //实体类 字段名（第一个字符大写）
            cd.setMaxFieldName(maxFieldName);
            //列备注
            cd.setColumnComment(comment);

            columnList.add(cd);
        }
        rs.close();
        ps.close();
        conn.close();

        return columnList;
    }


    /**
     * 获得该表的主键的对象，根据
     * @return
     */
    public static PrimaryKey getPrimaryKey(){
        return primaryKey ;
    }
}
