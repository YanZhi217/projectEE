package day23.Annotation6.Demo4;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取到Student类的字节码文件对象
        Class<?> clazz = Class.forName("day23.Annotation6.Demo4.Student");

        //获取注解。
        boolean result = clazz.isAnnotationPresent(Anno.class);
        System.out.println(result);
    }
}
