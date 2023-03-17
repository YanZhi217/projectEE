package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    //切入点表达式：
    @Pointcut("execution(void dao.BookDao.update())")
//    @Pointcut("execution(void dao.impl.BookDaoImpl.update())")
//    @Pointcut("execution(* dao.impl.BookDaoImpl.update(*))")    //no
//    @Pointcut("execution(void *.*.update())")
//    @Pointcut("execution(* *..*(..))")
//    @Pointcut("execution(* *..*e(..))")
//    @Pointcut("execution(void ..*())")
//    @Pointcut("execution(* *.*Service.find*(..))")
    //执行java包下的任意包下的名称以Service结尾的类或接口中的save方法，参数任意，返回值任意
    //@Pointcut("execution(* *.*Service.save(..))")
    private void pt(){}

    @Before("pt()")
    public void method(){
        System.out.println(System.currentTimeMillis());
    }
}
