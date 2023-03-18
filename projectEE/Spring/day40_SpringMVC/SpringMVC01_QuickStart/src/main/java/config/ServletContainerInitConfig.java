package config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

//Web容器配置类
public class ServletContainerInitConfig extends AbstractDispatcherServletInitializer {
    //加载SpringMVC配置类，产生SpringMVC容器，本质还是Spring容器
    protected WebApplicationContext createServletApplicationContext() {
        //初始化WebApplicationContext对象
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        //加载指定配置类
        ctx.register(SpringMvcConfig.class);
        return ctx;
    }

    //设置由springMVC控制器处理的请求映射路径
    protected String[] getServletMappings() {
        //表示所有
        return new String[]{"/"};
    }

    //加载Spring配置类
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
