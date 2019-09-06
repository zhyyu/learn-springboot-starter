package com.zhyyu.learn.springboot.starter.autoconfig;

import com.zhyyu.learn.springboot.api.testautoconfig.MyAutoConfigedBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试自定义 springboot-starter
 * <pre>
 *     参考文档: https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-developing-auto-configuration.html
 *
 *     1. 新建stater 项目, maven jar 包
 *     2. 配置自动配置类, 如 TestAutoConfig
 *     3. 创建META-INF/spring.factories, 如 org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
                com.zhyyu.learn.springboot.starter.autoconfig.TestAutoConfig
 *     4. 编写 TestAutoConfig, 若使用 @ConditionalOnClass(MyAutoConfigedBean.class) 注意 pom 相关依赖scope 设置为provided, 否则必定加载
 *          <dependency>
 *             <groupId>com.zhyyu.learn</groupId>
 *             <artifactId>learn-springboot-api</artifactId>
 *             <version>0.0.1-SNAPSHOT</version>
 *             <scope>provided</scope>
 *         </dependency>
 *     5. 其他项目依赖 如learn-springboot 依赖starter
 *           <dependency>
 *             <groupId>com.zhyyu.learn</groupId>
 *             <artifactId>learn-springboot-starter</artifactId>
 *             <version>0.0.1-SNAPSHOT</version>
 *         </dependency>
 *
 *         <dependency>
 *             <groupId>com.zhyyu.learn</groupId>
 *             <artifactId>learn-springboot-api</artifactId>
 *             <version>0.0.1-SNAPSHOT</version>
 *         </dependency>
 *
 *      项目启动即可从上线文中获取自动配置完成@Bean 对象
 *     @Autowired
 *     private MyAutoConfigedBean myAutoConfigedBean;
 *     @Autowired
 *     private ApplicationContext applicationContext;
 *
 * </pre>
 * @author juror
 * @datatime 2019/9/6 11:37
 */
@Configuration
@ConditionalOnClass(MyAutoConfigedBean.class)
public class TestAutoConfig {

    @Bean
    public MyAutoConfigedBean myAutoConfigedBean() {
        MyAutoConfigedBean myAutoConfigedBean = new MyAutoConfigedBean();
        myAutoConfigedBean.setI(1024);
        return myAutoConfigedBean;
    }

}
