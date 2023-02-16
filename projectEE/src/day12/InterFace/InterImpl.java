package day12.InterFace;

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
