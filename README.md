# quickDevelopProTemplate
快速开发项目模板（包含自动生成基本增删查改代码功能和基类）


使用说明：
1.代码生成器的使用：

使用步骤如下：
//1、先设置工作目录，数据库名，数据库连接url，用户账号和密码，
//2、设置各类包名参数和各类目录参数
//3、先往addTable()方法里的tableMap加表
//4、往addDocType()方法取自己需要生成的层代码，即不需要的层注释掉即可
//5、执行Main类的main()方法即可生成代码
（备注1：5个步骤都是在createCode包下的代码中执行，其中前4步在Params类中进行，
  最后一步即执行Main类的main()方法
  备注2：代码文件生成入口及全部实现代码都在
      cn.stephenchen.study.util.createCode包中（除一个依赖写在pom文件中）
   ）

2.整个后台项目运行
使用步骤：
1.修改application.properties文件的数据库url和账号密码
2.右键QuickDevelopProTemplateApplication ，选择 run 即可将项目跑起来

