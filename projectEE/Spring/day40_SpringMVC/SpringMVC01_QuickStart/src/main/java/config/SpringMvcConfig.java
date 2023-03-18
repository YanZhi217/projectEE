package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//SpringMVC配置类，本质上还是Spring配置类
@Configuration
@ComponentScan("controller")
public class SpringMvcConfig {
}
