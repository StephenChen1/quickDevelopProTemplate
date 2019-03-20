package cn.stephenchen.study.util.createCode;

/**
 * 表的字段信息
 */
public class ColumnData {

    /**是否为主键*/
    private String isPK;
    /**字段名称*/
    private String columnName;
    /**大写第一个字母属性名*/
    private String maxFieldName;
    /**属性名*/
    private String fieldName;

    private String dataType;
    private String jdbcType;
    private String columnComment;


    public String getIsPK() {
        return isPK;
    }

    public void setIsPK(String isPK) {
        this.isPK = isPK;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getMaxFieldName() {
        return maxFieldName;
    }

    public void setMaxFieldName(String maxFieldName) {
        this.maxFieldName = maxFieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }
}
