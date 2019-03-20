package cn.stephenchen.study.util.createCode;

import org.apache.velocity.VelocityContext;

import java.sql.Connection;
import java.util.Map;

/**
 * 代码生成工具类，设置某些变量，即可直接执行main方法生成各种代码
 */
public class CodeCreateUtil {


    public void create() {

        //遍历包含表信息的map，生成该表的相关代码文件
        for (Map.Entry<String, String> entry : Params.tableMap.entrySet()) {
            //表名
            String tableName = entry.getKey();
            //表注释
            String tableComment = entry.getValue();
            // oprateType CREATE生成代码文件（且覆盖），DELETE 删除代码文件
            oprateFile(entry.getKey(),tableComment, Params.oprateType);
        }

    }

    /**
     * @param tableName  表名
     * @param tableComment  表注释
     * @param oprateType 操作类型  CREATE 生成代码文件  DELETE 删除代码文件
     */
    private void oprateFile(String tableName,String tableComment, String oprateType) {


        /**表名转换为类名*/
        String className = ConvertUtil.tableNameToClassName(tableName);
        //得到第一个字符小写的类名
        String lowerName = className.substring(0, 1).toLowerCase() + className.substring(1, className.length());

        //基本包名
        String basePackage = Params.basePackage ;
        //controller包名
        String controllerPackage = Params.controllerPackage ;
        //service包名
        String servicePackage = Params.servicePackage ;
        //dao包名
        String daoPackage = Params.daoPackage ;
        //entity包名
        String entityPackage = Params.entityPackage ;

        //controller所在目录
        String controllerBasePath = Params.controllerBasePath ;
        //service所在目录
        String serviceBasePath = Params.serviceBasePath ;
        //dao所在目录
        String daoBasePath = Params.daoBasePath ;
        //实体类(entity)所在目录
        String entityBasePath = Params.entityBasePath ;
        //mapper.xml所在目录
        String mapBasePath = Params.mapBasePath ;

        VelocityContext context = new VelocityContext();
        context.put("className", className);
        context.put("lowerName", lowerName);
        context.put("tableComment", tableComment);
        context.put("tableName", tableName);
        context.put("basepkg", basePackage);
        context.put("controllerpkg",controllerPackage);
        context.put("servicepkg",servicePackage);
        context.put("daopkg",daoPackage);
        context.put("entitypkg",entityPackage);

        try {
            //连接数据库
            Connection conn = DataTableUtil.getConnection(Params.url, Params.userName, Params.password);
            if (conn == null) {
                System.out.println("===连接数据库失败！===");
                return;
            }
            //取得该表的列数据
            context.put("columnDatas", DataTableUtil.getColumnDatas(conn, Params.databaseName, tableName));
            PrimaryKey primaryKey = DataTableUtil.getPrimaryKey();
            context.put("pk", primaryKey);
        } catch (Exception e) {
            System.out.println("===获取表的列出错，出错报告如下：===");
            e.printStackTrace();
            System.out.println("===获取表的列出错，报告结束。===");
            return;
        }
        //遍历生成的代码文件类型，生成代码文件
        for (String docType : Params.docTypeList) {
            if ("db".equals(docType)) {
                //实体类路径
                String entityPath = "/" + className + ".java";
                //mapper路径
                String sqlMapperPath = "/" + className + "Dao.xml";
                if ("DELETE".equals(oprateType)) {
                    //删除实体(Entity)代码文件
                    DocOperateUtil.deleteFile(entityBasePath, entityPath);
                    //删除mapper.xml文件
                    DocOperateUtil.deleteFile(mapBasePath, sqlMapperPath);
                } else {
                    //生成实体类
                    DocOperateUtil.writeDoc(context, "TempTbl.java", entityBasePath, entityPath);
                    //生成mapper.xml
                    DocOperateUtil.writeDoc(context, "TempMapper.xml", mapBasePath, sqlMapperPath);
                }
            } else if ("service".equals(docType)) {
                String servicePath = "/" + className + "Service.java";
                if ("DELETE".equals(oprateType)) {
                    //删除service代码文件
                    DocOperateUtil.deleteFile(serviceBasePath, servicePath);
                } else {
                    // 生成Service代码文件
                    DocOperateUtil.writeDoc(context, "TempServiceImpl.java", serviceBasePath, servicePath);
                }
            } else if ("dao".equals(docType)) {
                String daoPath = "/" + className + "Dao.java";
                if ("DELETE".equals(oprateType)) {
                    //删除dao代码文件
                    DocOperateUtil.deleteFile(daoBasePath, daoPath);
                } else {
                    //生成Dao代码文件
                    DocOperateUtil.writeDoc(context, "TempDAOImpl.java", daoBasePath, daoPath);
                }
            } else if ("controller".equals(docType)) {
                String controllerPath = "/" + className + "Controller.java";
                if ("D".equals(oprateType)) {
                    DocOperateUtil.deleteFile(controllerBasePath, controllerPath);
                } else {
                    // 生成Controller
                    DocOperateUtil.writeDoc(context, "TempController.java", controllerBasePath, controllerPath);
                }
            } else {
                System.out.println("=====没有类型为" + docType + "的文件====");
            }
        }
    }


}
