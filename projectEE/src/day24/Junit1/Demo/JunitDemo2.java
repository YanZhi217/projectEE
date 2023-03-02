package day24.Junit1.Demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class JunitDemo2 {

    /*
    * @Test 表示测试该方法
    * @Before 在测试的方法前运行
    * @After 在测试的方法后运行
     */

    @Test
    public void test() {
        System.out.println("test");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @Before
    public void before() {
        System.out.println("before");
    }



}
