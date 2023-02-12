package day7;

public class student9 {
    //this代表当前调用方法的引用，哪个对象调用的方法，this就代表哪一个对象
    private String name;

    public void setName(String name){
        System.out.println("[方法中打印this]");
        System.out.println(this);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
