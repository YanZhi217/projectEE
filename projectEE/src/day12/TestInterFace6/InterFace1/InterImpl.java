package day12.TestInterFace6.InterFace1;

public class InterImpl implements Inter,InterA{

    @Override
    public void print1() {
        System.out.println("我是print1");
    }

    @Override
    public void print2() {
        System.out.println("我是print2");
    }

    @Override
    public void study() {
        System.out.println("我是study");
    }
}
