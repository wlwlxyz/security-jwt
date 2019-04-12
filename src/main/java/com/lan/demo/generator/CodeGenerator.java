package com.lan.demo.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

/**
 * @author: Lan
 * @date: 2019/4/4 15:32
 * @description:映射mysql数据库自动生成
 */
public class CodeGenerator {

    /**
     * 驱动名称
     */
    private static String driverClassName = "com.mysql.jdbc.Driver";

    /**
     * 数据库连接url
     */
    private static String url = "jdbc:mysql://127.0.0.1:3306/security-jwt?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&useSSL=false&serverTimezone=GMT%2B8";

    /**
     * 数据库连接用户名
     */
    private static String username = "root";

    /**
     * 数据库连接密码
     */
    private static String password = "12345";

    public static void main(String[] args) {
        String[] tables = new String[]{"user", "role", "permission",
                "user_role", "role_permission"};
        generator(tables);
    }

    private static void generator(String[] tables) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName(driverClassName);
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        //包名配置
        PackageConfig pc = new PackageConfig();
        //父包名
        pc.setParent("com.lan.demo");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //【实体】是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(true);
        //生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        //需要包含的表名，允许正则表达式（与exclude二选一配置）
        strategy.setInclude(tables);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new VelocityTemplateEngine());

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //项目当前路径
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("Lan");
        mpg.setGlobalConfig(gc);

        mpg.execute();
    }
}
