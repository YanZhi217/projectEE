package day12;

public class Zi14 extends Fu13{
    public void show(){
        System.out.println("子类show方法");
    }

    public void method(){
        this.show();
        super.show();
    }
}
