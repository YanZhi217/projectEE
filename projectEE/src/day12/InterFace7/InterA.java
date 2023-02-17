package day12.InterFace7;

public interface InterA {
    public abstract void showA();

    public default void method(){
        System.out.println("InterA...method方法");
    }
}
