import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator1 {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/generatedb", "admin", "123456")
                // 全局配置
                .globalConfig(builder -> {
                    builder.author("zry") // 设置作者
                            .outputDir("Esgeneratedb/src/main/java"); // 指定输出目录
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("com.es.gen") // 设置父包名
                            .moduleName("gendb") // 设置模块名
                            .controller("controller") // 设置 Controller 包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "src/main/resources/mapper")); // 设置 mapperXml 生成路径
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder
                            //.addInclude("system_database_info")
//                            .addTablePrefix("t_", "c_") // 设置过滤表前缀
                            .controllerBuilder()
                            .enableHyphenStyle() // 开启驼峰转连字符
                            .enableRestStyle(); // 开启生成 @RestController 控制器
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
