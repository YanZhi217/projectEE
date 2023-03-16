package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"dao","service",})
//@PropertySource加载properties配置文件
@PropertySource({"classpath:jdbc.properties"})
public class SpringConfig {
}
