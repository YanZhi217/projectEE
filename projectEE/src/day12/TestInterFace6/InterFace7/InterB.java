package day12.TestInterFace6.InterFace7;

public interface InterB {
    public abstract void showB();

    public default void method(){
        System.out.println("InterB...method方法");
    }
}
