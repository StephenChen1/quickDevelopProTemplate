package cn.stephenchen.study.util.createCode;

/**
 * 代码生成入口类
 */
public class Main {

    /**
     * 设置Params对象的各种参数，然后执行此方法即可生成代码文件
     */
    public static void main(String[] args) {
        //去Params类设置参数
        Params.init();
        //将需要生成代码的表加入Map
        Params.addTable();
        //将需要生成的文件类型加入map
        Params.addDocType();
        //开始生成代码文件
        CodeCreateUtil codeCreateUtil = new CodeCreateUtil();
        codeCreateUtil.create();


    }

}
