package day12.TestInnerClass8;

public class test6 {
    public static void main(String[] args) {
        goSwimming(new Swimming() {
            @Override
            public void swim() {
                System.out.println("铁汁, 我们去游泳吧");
            }
        });

    }

    /**
     * 使用接口的方法
     */
    public static void goSwimming(Swimming swimming){
        /*
          多态:
            Swimming swim = new Swimming() {
                @Override
                public void swim() {
                    System.out.println("铁汁, 我们去游泳吧");
                }
            }
         */
        swimming.swim();
    }
}

/*
    游泳接口
 */
interface Swimming {
    void swim();
}