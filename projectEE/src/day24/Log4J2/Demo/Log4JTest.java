package day24.Log4J2.Demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    日志
    程序中的日志可以用来记录程序在运行的时候点点滴滴。并可以进行永久存储。
    日志与输出语句的区别
类别        输出语句                    日志技术
取消日志: 需要修改代码，灵活性比较差 ,不需要修改代码，灵活性比较好
输出位置: 只能是控制台            ,可以将日志信息写入到文件或者数据库中
多线程:  和业务代码处于一个线程中  ,多线程方式记录日志，不影响业务代码的性能

配置文件详解
    Log4J三个核心
        Loggers(记录器) 日志的级别
            Loggers组件在此系统中常见的五个级别：DEBUG、INFO、 WARN、ERROR、 FATAL
            DEBUG 基本信息， INFO 重要信息， WARN 轻微警告， ERROR 严重警告(还不会影响程序运行)， FATAL 错误(影响程序运行)
            优先级     DEBUG < INFO < WARN < ERROR < FATAL。
            Log4j有一个规则：只输出级别不低于设定级别的日志信息。

        Appenders(输出源) 日志要输出的地方
            把日志输出到不同的地方，如控制台（Console）、文件（Files）等。
            org.apache.log4j.ConsoleAppender（控制台）
            org.apache.log4j.FileAppender（文件）

        Layouts(布局) 日志输出的格式
            可以根据自己的喜好规定日志输出的格式
            常用的布局管理器：
                org.apache.log4j.PatternLayout（可以灵活地指定布局模式）
                org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串）
                org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等信息）

        配置根Logger
            格式
                log4j.rootLogger=日志级别，appenderName1，appenderName2，…
            日志级别
                OFF、FATAL、ERROR、WARN、INFO、DEBUG、ALL或者自定义的级别
            appenderName1
                就是指定日志信息要输出到哪里。可以同时指定多个输出目的地，用逗号隔开。
                例如：log4j.rootLogger＝INFO，ca，fa

            ConsoleAppender常用的选项
                ImmediateFlush=true
                    表示所有消息都会被立即输出，设为false则不输出，默认值是true。
                Target=System.err  默认值是System.out。
                    System.err代表输红色字体，System.out代表输出黑色字体

            FileAppender常用的选项
                ImmediateFlush=true
                    表示所有消息都会被立即输出。设为false则不输出，默认值是true
                Append=false
                    true表示将消息添加到指定文件中，原来的消息不覆盖。
                    false则将消息覆盖指定的文件内容，默认值是true。
                File=D:/logs/logging.log4j
                    指定消息输出到logging.log4j文件中

            PatternLayout常用的选项
                ConversionPattern=%m%n
                    设定以怎样的格式显示消息
 */
public class Log4JTest {
    //使用log4j的api来获取日志的对象
    //弊端：如果以后我们更换日志的实现类，那么下面的代码就需要跟着改
    //不推荐使用
    //private static final Logger LOGGER = Logger.getLogger(Log4JTest.class);


    //使用slf4j里面的api来获取日志的对象
    //好处：如果以后我们更换日志的实现类，那么下面的代码不需要跟着修改
    //推荐使用
    private static  final Logger LOGGER = LoggerFactory.getLogger(Log4JTest.class);


    public static void main(String[] args) {
        //1.导入jar包
        //2.编写配置文件
        //3.在代码中获取日志的对象
        //4.按照日志级别设置日志信息

        //debug不会打印，因为log4j.properties里面log4j.rootLogger=info,my,fileAppender，把info修改为debug就可以显示了
        LOGGER.debug("debug级别的日志");
        LOGGER.info("info级别的日志");
        LOGGER.warn("warn级别的日志");
        LOGGER.error("error级别的日志");


    }
}
