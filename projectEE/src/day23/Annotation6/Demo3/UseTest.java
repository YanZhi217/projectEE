package day23.Annotation6.Demo3;

public class UseTest {
    public UseTest() {
    }

    //没有使用Test注解
    public void show(){
        System.out.println("UseTest....show....");
    }

    //使用Test注解
    @Test
    public void method(){
        System.out.println("UseTest....method....");
    }


    //没有使用Test注解
    @Test
    public void function(){
        System.out.println("UseTest....function....");
    }
}