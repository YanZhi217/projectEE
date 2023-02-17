package day12.InnerClass;

public class test3 {
    /*
        静态成员内部类演示
     */
    public static void main(String[] args) {
        // 外部类名.内部类名 对象名 = new 外部类名.内部类名();
        Outer3.Inner oi = new Outer3.Inner();
        oi.show();

        Outer3.Inner.method();
    }
}

class Outer3 {
    static class Inner {
        public void show(){
            System.out.println("inner..show");
        }

        public static void method(){
            System.out.println("inner..method");
        }
    }
}