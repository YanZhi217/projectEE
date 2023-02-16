package day12.test_abstract;

public abstract class Animal {
    public void drink(){
        System.out.println("喝水");
    }

    public Animal(){
    }

    public abstract void eat();
}
