package day22.MyReflect2.Demo3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

/**
 * 获取Constructor对象并创建对象
 * Constructor.newInstance(构造方法实参)
 * Constructor.setAccessible(boolean)    用于取消对私有成员的访问检查(暴力反射)
 */
public class Demo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //T newInstance(Object... initargs)：根据指定的构造方法创建对象
        method1();
        System.out.println();
        method2();
        System.out.println();
        method3();
        System.out.println();
        method4();

    }

    private static void method4() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //获取一个私有的构造方法并创建对象
        //1.获取class对象
        Class<?> clazz = Class.forName("day22.MyReflect2.Demo3.Student");

        //2.获取一个私有化的构造方法.
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);

        //被private修饰的成员,不能直接使用的
        //如果用反射强行获取并使用,需要临时取消访问检查
        constructor.setAccessible(true);

        //3.直接创建对象
        Student student = (Student) constructor.newInstance("ZhangSan");

        System.out.println(student);
    }

    private static void method3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //简写格式
        //1.获取class对象
        Class<?> clazz = Class.forName("day22.MyReflect2.Demo3.Student");

        //2.在Class类中,有一个newInstance方法,可以利用空参直接创建一个对象
        Student student = (Student) clazz.newInstance();//这个方法现在已经过时了,了解一下

        System.out.println(student);
    }

    private static void method2() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1.获取class对象
        Class<?> clazz = Class.forName("day22.MyReflect2.Demo3.Student");

        //2.获取单个公共构造方法对象
        Constructor<?> constructor = clazz.getConstructor();

        //3.利用空参来创建Student的对象
        Student student = (Student) constructor.newInstance();

        System.out.println(student);
    }

    private static void method1() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1.获取class对象
        Class<?> clazz = Class.forName("day22.MyReflect2.Demo3.Student");

        //2.获取单个公共构造方法对象
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);

        //3.利用newInstance创建Student的对象
        Student student = (Student) constructor.newInstance("ZhangSan", 23);

        System.out.println(student);
    }
}
