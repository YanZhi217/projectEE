package day12.constructor3;

public class test4 {
    public static void main(String[] args) {
        Zi z = new Zi();
    }
}


class Fu {
    int age;

    // 空参数构造方法
    public Fu(){
        System.out.println("父类空参数构造方法");
    }

    // 带参数构造方法
    public Fu(int age){
        this.age = age;
    }
}


 class Zi extends Fu {
    public Zi(){
        this(10); // 不存在super();,因为super和this不能共存，super和this必须在第一行
    }

    public Zi(int age){
        super(age); //当父类没有空参构造方法时，可以手动super父类带参构造方法
    }
}

