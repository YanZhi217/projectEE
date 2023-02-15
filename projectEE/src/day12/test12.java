package day12;

public class test12 {
    /*
        this&super关键字：
            this：代表本类对象的引用
        super：代表父类存储空间的标识(可以理解为父类对象引用)
        this和super的使用分别
        成员变量：
            this.成员变量 - 访问本类成员变量
        super.成员变量 - 访问父类成员变量
        成员方法：
            this.成员方法 - 访问本类成员方法
        super.成员方法 - 访问父类成员方法
        构造方法：
            this(…) - 访问本类构造方法
        super(…) - 访问父类构造方法
    */
    public static void main(String[] args) {
        Zi11 z = new Zi11();
        z.method();
    }
}
