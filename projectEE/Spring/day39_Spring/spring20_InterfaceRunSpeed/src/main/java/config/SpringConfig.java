package config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({"aop","config","dao","domain","service"})
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
@EnableAspectJAutoProxy
public class SpringConfig {
}
