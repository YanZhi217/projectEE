package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"aop","config","dao"})
//开启注解开发AOP功能
@EnableAspectJAutoProxy
public class SpringConfig {
}
