package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"aop","config","dao","service"})
@EnableAspectJAutoProxy
public class SpringConfig {
}
