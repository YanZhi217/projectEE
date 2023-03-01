package day22.MyClassLoader1;

/**
 *  获取类加载器
 *  类加载器的作用：负责将.class文件（存储的物理文件）加载在到内存中
 *  类加载时机(啥时候用啥时候加载)
 *      创建类的实例（对象）
 *      调用类的类方法
 *      访问类或者接口的类变量，或者为该类变量赋值
 *      使用反射方式来强制创建某个类或接口对应的java.lang.Class对象
 *      初始化某个类的子类
 *      直接使用java.exe命令来运行某个主类
 * 类加载的过程 --- 加载 -- 验证 -- 准备 -- 解析 -- 初始化 --- 验证准备解析统称为链接
 * 加载
 *      通过包名 + 类名，获取这个类，准备用流进行传输
 *      在这个类加载到内存中
 *      加载完毕创建一个class对象
 * 链接
 *  验证
 *      确保Class文件字节流中包含的信息符合当前虚拟机的要求，并且不会危害虚拟机自身安全(文件中的信息是否符合虚拟机规范有没有安全隐患)
 *  准备
 *      负责为类的类变量（被static修饰的变量）分配内存，并设置默认初始化值(初始化静态变量)
 *  解析
 *      将类的二进制数据流中的符号引用替换为直接引用(本类中如果用到了其他类，此时就需要找到对应的类,例如String)
 * 初始化
 *      根据程序员通过程序制定的主观计划去初始化类变量和其他资源(静态变量赋值以及初始化其他资源)
 * 类加载器的分类
 *      Bootstrap class loader：虚拟机的内置启动类加载器，通常表示为null ，并且没有父null
 *      Platform class loader：平台类加载器,负责加载JDK中一些特殊的模块
 *      System class loader：系统类加载器,负责加载用户类路径上所指定的类库
 * 双亲委派模型
 *      如果一个类加载器收到了类加载请求，它并不会自己先去加载，而是把这个请求委托给父类的加载器去执行，如果父类加载器还存在其父类加载器，则进一步向上委托，依次递归，
 *      请求最终将到达顶层的启动类加载器，如果父类加载器可以完成类加载任务，就成功返回，倘若父类加载器无法完成此加载任务，子加载器才会尝试自己去加载，这就是双亲委派模式
 */
public class Demo1 {
    public static void main(String[] args) {
        /*
            public static ClassLoader getSystemClassLoader() 获取系统类加载器
            public InputStream getResourceAsStream(String name) 加载某一个资源文件
        */

        //获取系统类加载器 -- SystemClassLoader
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        //获取系统类加载器的父加载器 --- 平台类加载器 -- PlatFormClassLoader
        ClassLoader classLoader1 = systemClassLoader.getParent();

        //获取平台类加载器的父加载器 --- 启动类加载器 -- BootStrapClassLoader,通常以null表示
        ClassLoader classLoader2 = classLoader1.getParent();

        System.out.println("系统类加载器" + systemClassLoader);
        System.out.println("平台类加载器" + classLoader1);
        System.out.println("启动类加载器" + classLoader2);

    }
}
