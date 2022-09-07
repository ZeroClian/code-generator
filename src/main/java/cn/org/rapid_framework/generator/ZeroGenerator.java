package cn.org.rapid_framework.generator;


import java.io.File;
import java.io.IOException;

/**
 * 代码生成器
 *
 * @Author: qiyiguo
 * @Date: 2021-09-02 2:03 下午
 */
public class ZeroGenerator {
    public static void main(String[] args) throws Exception {

        // TODO 设置模板
        // 1. template: spring jpa
        // 2. mybatis-template: mybatis
        GeneratorProperties.setProperty("templatePath", "ccjk");
        GeneratorFacade generatorFacade = initConfig();

        //GeneratorProperties.setProperty("jdbc_url", "jdbc:mysql://127.0.0.1:3306/zero-web?useUnicode=true&characterEncoding=UTF-8&useInformationSchema=true&enabledTLSProtocols=TLSv1.2&useSSL=false&serverTimezone=Asia/Shanghai");
        GeneratorProperties.setProperty("jdbc_url", "jdbc:mysql://119.28.17.102/co3?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false&rewriteBatchedStatements=true");
        GeneratorProperties.setProperty("jdbc_username", "co3");
        GeneratorProperties.setProperty("jdbc_password", "co3@2021");

        // TODO 设置包名
        GeneratorProperties.setProperty("basepackage", "com.ccjk.co3.integration.mail");

        // TODO 设置表前缀
        GeneratorProperties.setProperty("tableRemovePrefixes", "");

        //TODO 填入要生成代码的表名称，多个表以 ',' 分开
        String tables = "mail_sent_record";

        for (String table : tables.split(",")) {
            generatorFacade.generateByTable(table.trim());
        }

    }

    /**
     * 初始化基本配置,
     *
     * @return 生成器对象
     */
    private static GeneratorFacade initConfig() throws IOException {
        GeneratorProperties.setProperty("jdbc_driver", "com.mysql.cj.jdbc.Driver");
        File outputPath = new File(System.getProperty("user.dir") + "/0out");
        if (!outputPath.exists()) {
            outputPath.mkdirs();
        }
        // 设置输出目录
        GeneratorProperties.setProperty("outRoot", outputPath.getAbsolutePath());
        GeneratorFacade generatorFacade = new GeneratorFacade();
        generatorFacade.deleteOutRootDir();
        String templatePath = GeneratorProperties.getProperty("templatePath");
        generatorFacade.getGenerator().addTemplateRootDir("classpath:" + templatePath);
        return generatorFacade;
    }
}
