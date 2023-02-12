package day5;

public class method1 {
    /*方法就是具有独立功能的代码块，不调用就不执行
       方法的定义格式:
               public static void 方法名 (){
                   方法体
               }
       方法的调用格式:
               方法名();
       注意: 方法与方法之间是平级关系, 不能嵌套定义
    */
    public static void main(String[] args) {
        eat();
    }

    public static void eat (){
        study();
        System.out.println("吃饭");
    }

    public static void study(){
        System.out.println("学习");
    }
}
