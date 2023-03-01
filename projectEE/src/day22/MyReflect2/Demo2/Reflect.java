package day22.MyReflect2.Demo2;

/**
 * 反射机制
 *      是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法； 对于任意一个对象，都能够调用它的任意属性和方法；
 *      这种动态获取信息以及动态调用对象方法的功能称为Java语言的反射机制
 * 获取class对象的三种方式
 *      Class.FroName("全类名")
 *      类名.class
 *      对象名.getClass()
 */
public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class类中的静态方法forName("全类名")
        //全类名:包名 + 类名
        Class<?> clazz = Class.forName("day22.MyReflect2.Demo2.Student");
        System.out.println(clazz);

        //2.通过class属性来获取
        Class<Student> clazz2 = Student.class;
        System.out.println(clazz2);

        //3.利用对象的getClass方法来获取class对象
        //getClass方法是定义在Object类中.
        Student s = new Student();
        Class<? extends Student> clazz3 = s.getClass();
        System.out.println(clazz3);

        System.out.println(clazz == clazz2);
        System.out.println(clazz2 == clazz3);
    }
}