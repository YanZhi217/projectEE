package day24.Junit1.Demo;

import org.junit.Test;
public class JunitDemo1 {
    /*
    * Junit
    * JUnit是一个 Java 编程语言的单元测试工具。JUnit 是一个非常重要的测试工具
    * JUnit是一个开放源代码的测试工具。
    * 提供注解来识别测试方法。
    * JUnit测试可以让你编写代码更快，并能提高质量。
    * JUnit优雅简洁。没那么复杂，花费时间较少。
    * JUnit在一个条中显示进度。如果运行良好则是绿色；如果运行失败，则变成红色。
    *
    * 使用步骤
    * 1. 将junit的jar包导入到工程中 junit-4.9.jar
    * 2. 编写测试方法该测试方法必须是公共的无参数无返回值的非静态方法
    * 3. 在测试方法上使用@Test注解标注该方法是一个测试方法
    * 4. 选中测试方法右键通过junit运行该方法
     */
    public static void main(String[] args) {

    }

    @Test
    public void add() {
        System.out.println(2 / 0);
        int a = 10;
        int b = 20;
        int sum = a + b;
        System.out.println(sum);
    }
}
