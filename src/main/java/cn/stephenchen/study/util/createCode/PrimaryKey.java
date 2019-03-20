package cn.stephenchen.study.util.createCode;

/**
 * 主键bean
 */
public class PrimaryKey {


    /**表的主键列名*/
    private String keyName;
    /**表的主键的实体字段名*/
    private String keyFieldName;
    /**java类型*/
    private String keyJavaType;
    /**jdbc类型*/
    private String keySqlType;

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyFieldName() {
        return keyFieldName;
    }

    public void setKeyFieldName(String keyFieldName) {
        this.keyFieldName = keyFieldName;
    }

    public String getKeyJavaType() {
        return keyJavaType;
    }

    public void setKeyJavaType(String keyJavaType) {
        this.keyJavaType = keyJavaType;
    }

    public String getKeySqlType() {
        return keySqlType;
    }

    public void setKeySqlType(String keySqlType) {
        this.keySqlType = keySqlType;
    }
}
