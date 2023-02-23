package day12.TestInterFace6.InterFace5;

public interface Inter {

    //默认方法，带有主题的方法即是默认方法，默认方法可以调用私有的静态和非静态方法
    public default void start() {
        System.out.println("start方法执行了...");
        log();
    }


    public default void end() {
        System.out.println("end方法执行了...");
        log();
    }

    //私有方法，当多个默认或静态方法具有相同的方法体，则可以调用私有方法将公共部分抽取出来
    private void log(){
        System.out.println("日志记录 ( 模拟 )");
    }

    private static void check(){
        System.out.println("权限校验 ( 模拟 )");
    }

    //静态方法，希望默认方法调用更加简洁，则可以使用静态方法
    public static void open() {
        check();
        System.out.println("open方法执行了");
    }

    public static void close(){
        check();
        System.out.println("close方法执行了");
    }
}
