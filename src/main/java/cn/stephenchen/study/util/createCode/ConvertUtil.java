package cn.stephenchen.study.util.createCode;

/**
 * 转换工具类 包含各种的转换，专用于生成代码部分
 */
public class ConvertUtil {

    /**
     * 表名转换成类名 目标：第一个字符大写，_ 后的第一个字符也大写
     *
     * @param tableName
     * @return
     */
    public static String tableNameToClassName(String tableName) {
        //根据_切成字符串数组
        String[] split = tableName.split("_");
        StringBuffer sb = new StringBuffer();
        for (String element : split) {
            //切后的每个字符串的第一个字母大写
            String tempTableName = element.substring(0, 1).toUpperCase() + element.substring(1, element.length());
            sb.append(tempTableName);
        }
        System.out.println("tableName:" + tableName + "==>" + "className:" + sb.toString());
        return sb.toString();
    }

    /**
     * 表的字段名转换成实体类的字段名
     * 只适合以下情况：表的字段名样式 test_test_test  即没有大写，转换后 _ 后第一个字母大写
     * 目标：转换成java规范的驼峰式命名法
     *
     * @param columnName
     * @return
     */
    public static String columnNameToFieldName(String columnName) {
        String[] split = columnName.split("_");

        StringBuffer sb = new StringBuffer();
        for (String element : split) {
            String tempTableName = element.substring(0, 1).toUpperCase() + element.substring(1, element.length())
                    .toLowerCase();
            sb.append(tempTableName);
        }

        String tempField = sb.toString();
        System.out.println(tempField);

        return tempField.substring(0, 1).toLowerCase() + tempField.substring(1, tempField.length());

    }

    /**
     * 表的字段数据类型转换为java实体类的字段数据类型
     * @param columnType
     * @return
     */
    public static String columnTypeToFieldType(String columnType){
        String otype = columnType;
        String type = columnType.toLowerCase();
        if ("char".equals(type) || "varchar".equals(type) || type.indexOf("text") >= 0 || "enum".equals(type)) {
            return "String";
        } else if (type.indexOf("float") >= 0) {
            return "Float";

        } else if (type.indexOf("decimal") >= 0) {
            return "java.math.BigDecimal";

        } else if (type.indexOf("double") >= 0) {
            return "Double";

        } else if ("int".equals(type) || "smallint".equals(type)) {
            return "Integer";
        } else if ("tinyint".equals(type)) {
            return "Integer";
        } else if ("bigint".equals(type)) {
            return "Long";
        } else if ("timestamp".equals(type) || "date".equals(type) || "datetime".equals(type)) {
            return "java.util.Date";
        }
        return otype;
    }

    /***
     * 表的字段数据类型转换成jdbcType
     * @param columnType
     * @return
     */
    public static String columnTypeToJdbcType(String columnType){
        String otype = columnType;
        String type = columnType.toLowerCase();
        if ("char".equals(type)) {
            return "CHAR";
        }

        if ("varchar".equals(type) || "enum".equals(type)) {
            return "VARCHAR";
        }

        if ("text".equals(type)) {
            return "VARCHAR";
        }

        if (type.indexOf("float") >= 0) {
            return "DOUBLE";

        }
        if (type.indexOf("decimal") >= 0) {
            return "NUMERIC";

        }
        if (type.indexOf("double") >= 0) {
            return "DOUBLE";

        }
        if ("int".equals(type)) {
            return "INTEGER";
        }

        if ("tinyint".equals(type)) {
            return "TINYINT";
        }

        if ("bigint".equals(type)) {
            return "BIGINT";
        }

        if ("timestamp".equals(type) || "datetime".equals(type)) {
            return "TIMESTAMP";
        }

        if ("date".equals(type)) {
            return "DATE";
        }

        return otype.toUpperCase();
    }


    /**
     * 表字段数据类型转换为全名的java数据类型
     * @return
     */
    public static String columnTypeToFullJavaType(String columnType){
        String otype = columnType;
        String type = columnType.toLowerCase();
        if ("char".equals(type) || "varchar".equals(type) || type.indexOf("text") >= 0) {
            return "java.lang.String";
        } else if (type.indexOf("float") >= 0) {
            return "java.lang.Float";

        } else if (type.indexOf("decimal") >= 0) {
            return "java.math.BigDecimal";

        } else if (type.indexOf("double") >= 0) {
            return "java.lang.Double";

        } else if ("int".equals(type)) {
            return "java.lang.Integer";
        } else if ("tinyint".equals(type)) {
            return "java.lang.Integer";
        } else if ("bigint".equals(type)) {
            return "java.lang.Long";
        } else if ("timestamp".equals(type) || "date".equals(type) || "datetime".equals(type)) {
            return "java.util.Date";
            // return "java.sql.Timestamp";
        }
        return otype;
    }


    /**
     * 将字段名转换成第一个字符大写
     * @param fieldName
     * @return
     */
    public static String fieldNameToMaxFieldName(String fieldName){

        return fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());

    }

}
