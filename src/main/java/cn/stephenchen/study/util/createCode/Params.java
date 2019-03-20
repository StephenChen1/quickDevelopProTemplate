package cn.stephenchen.study.util.createCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 代码生成参数，相当于配置参数，
 * 一般需求的代码生成，更改这里的需求即可
 */
public class Params {


    /**
     * 工作目录（即项目目录）
     */
    public static String workSpaceUrl = "F:/graduationDesign/stephenchen/houtai/quickDevelopProTemplate";
    /**
     * 数据库名
     */
    public static String databaseName = "hospital_navigator_manage";
    /**
     * 连接数据库的url
     */
    public static String url = "jdbc:mysql://127.0.0.1:3306/" + databaseName + "?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    /**
     * 用户数据库账号
     */
    public static String userName = "root";
    /**
     * 用户数据库密码
     */
    public static String password = "";
    /**
     * 需要进行的操作(默认是生成) CREATE 生成新的代码文件(会覆盖旧的文件)  DELETE 删除文件
     */
    public static String oprateType = "CREATE";
    /**
     * 是否可以替换文件(默认可替换即可) true =可以替换，false =不可以替换
     */
    public static boolean isReplace = true;
    /**
     * 文件编码格式
     */
    public final static String CONTENT_ENCODING = "UTF-8";


    /**
     * 基本包名
     */
    public static String basePackage = "cn.stephenchen.study";
    /**
     * controller包名
     */
    public static String controllerPackage = "cn.stephenchen.study.controller";
    /**
     * service包名
     */
    public static String servicePackage = "cn.stephenchen.study.service";
    /**
     * dao包名
     */
    public static String daoPackage = "cn.stephenchen.study.dao";
    /**
     * entity包名
     */
    public static String entityPackage = "cn.stephenchen.study.entity";

    /**
     * controller所在目录
     */
    public static String controllerBasePath = workSpaceUrl + "/src/main/java/cn/stephenchen/study/controller";
    /**
     * service所在目录
     */
    public static String serviceBasePath = workSpaceUrl + "/src/main/java/cn/stephenchen/study/service";
    /**
     * dao所在目录
     */
    public static String daoBasePath = workSpaceUrl  + "/src/main/java/cn/stephenchen/study/dao";
    /**
     * 实体类(entity)所在目录
     */
    public static String entityBasePath = workSpaceUrl + "/src/main/java/cn/stephenchen/study/entity";
    /**
     * mapper.xml所在目录
     */
    public static String mapBasePath = workSpaceUrl  + "/src/main/resources/mapper";


    /**
     * 需要生成代码文件的表集合 key 为表名，value 为该表的说明（可以随便写）
     */
    public static Map<String, String> tableMap = new HashMap<>();
    /**
     * 需要生成的代码文件的类型
     */
    public static List<String> docTypeList = new ArrayList<>();


    /**
     * 将需要生成代码文件的表加入map key为表名(务必正确)，value为表注释（随意写）
     */
    public static void addTable() {
        tableMap.put("hospi_record", "医院记录表");
        tableMap.put("address", "地点信息表");
        tableMap.put("userInfo", "用户信息表");
        tableMap.put("navigation_record", "导航记录表");
        tableMap.put("hospi_flow_record", "就医流程节点记录表");
        //tableMap.put("tips", "生活小贴士表");

    }

    /**
     * 将需要生成的文件类型加入map
     */
    public static void addDocType() {
        //生成dao.xml和实体类
        docTypeList.add("db");
        //生成dao层
        //docTypeList.add("dao");
        //生成service层
        //docTypeList.add("service");
        //生成controller层
        //docTypeList.add("controller");
    }

    /**
     * 本方法不做任何操作，只是提示该完善本类的参数了
     * （所有的基本配置在本类完成即可，如需更高级的功能，可自行研究代码）
     */
    public static void init() {
        //1、先设置工作目录，数据库名，数据库连接url，用户账号和密码，
        //2、设置各类包名参数和各类目录参数
        //3、先往addTable()方法里的tableMap加表
        //4、往addDocType()方法取自己需要生成的层代码，即不需要的层注释掉即可
        //5、执行Main类的main()方法即可生成代码
    }


}
