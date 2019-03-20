package cn.stephenchen.study.util.createCode;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

/**
 * 目标文件生成工具类
 */
public class DocOperateUtil {

    /**速度引擎？*/
    private static VelocityEngine ve;





    static {
        try {
            //获取文件模板根路径
            String templateBasePath = Params.workSpaceUrl + "/src/main/resources/codeTemplate";
            Properties properties = new Properties();
            properties.setProperty(RuntimeConstants.RESOURCE_LOADER, "file");
            properties.setProperty("file.resource.loader.description", "Velocity File Resource Loader");
            properties.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, templateBasePath);
            properties.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_CACHE, "true");
            properties.setProperty("file.resource.loader.modificationCheckInterval", "30");
            properties.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute");
            properties.setProperty("runtime.log.logsystem.log4j.logger", "org.apache.velocity");
            properties.setProperty("directive.set.null.allowed", "true");
            VelocityEngine velocityEngine = new VelocityEngine();
            velocityEngine.init(properties);
            ve = velocityEngine;
        } catch (Exception e) {
            System.out.println("===获取文件面出错，报告如下：===");
            e.printStackTrace();
            System.out.println("===获取文件面出错，报告结束。===");
        }
    }

    /**
     *
     * @param context
     * @param templateName 模板名
     * @param fileDirPath 目标输出文件基础目录
     * @param targetFile 目标文件
     */
    public static void writeDoc(VelocityContext context, String templateName, String fileDirPath, String targetFile){

        try {
            File file = new File(fileDirPath + targetFile);
            if (!file.exists()) {
                new File(file.getParent()).mkdirs();
            } else {
                if (Params.isReplace) {
                    System.out.println("替换文件" + file.getAbsolutePath());
                } else {
                    System.out.println("页面生成失败" + file.getAbsolutePath() + "文件已存在");
                    return;
                }
            }

            Template template = ve.getTemplate(templateName, Params.CONTENT_ENCODING);
            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos, Params.CONTENT_ENCODING));
            template.merge(context, writer);
            writer.flush();
            writer.close();
            fos.close();
            System.out.println("页面生成成功" + file.getAbsolutePath());
        } catch (Exception e) {

        }

    }

    /**
     * 删除文件
     * @param basePath 基本目录
     * @param filePath 包括后缀的尾部文件路径
     */
    public static void deleteFile(String basePath,String filePath){
        File file = new File(basePath + filePath);
        if (file.exists()) {
            System.out.println("删除文件" + file.getAbsolutePath());
            file.delete();
        }
    }



}
