package day12.TestInnerClass8;

public class test4 {
    /*
        局部内部类:

            编写位置: 方法中
            访问方式: 只能在方法中, 创建对象并访问
     */
    public static void main(String[] args) {
        Outer4 o = new Outer4();
        o.method();
    }
}

class Outer4 {
    int a = 10;
    public void method(){
        int b = 20;
        class Inner {
            public void show(){
                System.out.println("show...");
                System.out.println(a);
                System.out.println(b);
            }
        }
        Inner i = new Inner();
        i.show();
    }
}