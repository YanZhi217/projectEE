package day12.TestExtends1.OverRide7;

public class Zi20 extends Fu19 {
    //@Override // 注解: 检查当前的方法是否是一个正确的重写方法
    /*
        1. 私有方法不能被重写(父类私有成员子类是不能继承的)
        2. 子类方法访问权限不能更低(public > 默认 > protected > 私有)
        3. 静态方法不能被重写,如果子类也有相同的方法,并不是重写的父类的方法,而是将父类中的方法隐藏了起来
    */
    public static void show() {
        System.out.println("Zi...");
    }

    @Override
    public void method() {
        super.method();
        System.out.println("Zi......method");
    }
}
