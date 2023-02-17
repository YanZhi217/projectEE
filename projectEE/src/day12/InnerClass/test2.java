package day12.InnerClass;

public class test2 {
    /*
        私有成员内部类演示
     */
    public static void main(String[] args) {

        Outer2 o = new Outer2();
        o.method();
    }
}

class Outer2 {
    private class Inner2 {
        public void show(){
            System.out.println("inner..show");
        }
    }

    public void method(){
        Inner2 i = new Inner2();
        i.show();
    }
}