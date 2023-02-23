package day12.TestExtends1.OverRide7;

public class test21 {
    /*
    * 父类中私有方法不能被重写
    * 父类静态方法，子类必须通过静态方法进行重写，父类非静态方法，子类也必须使用非静态方法进行重写
    * 静态方法不能被重写，如果子类中也存在一个方法声明一模一样的方法，可以理解为子类将父类中同名的方法隐藏了，并非得是方法重写
    * 子类重写父类方法时，访问权限必须大于等于父类
    * 四个权限修饰符，private < default(默认) < protected < public
    * 访问权限       同一类中 < 同一包中 < 不同包中子类 < 不同包中无关类
    * */
    public static void main(String[] args) {
        Zi20 z = new Zi20();
        z.show();
        z.method();
    }
}
