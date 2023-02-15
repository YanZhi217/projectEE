package day12;

public class iPear17 extends iPear16{
    /*
        2. 定义新手机类 iPearV2
                    call(String name) : 打电话方法
                    smallBlack() : 语音助手 (speak english...  说中文)

       方法重写的应用场景:
            当子类需要父类的功能，而功能主体子类有自己特有内容
            可以重写父类中的方法，这样，即沿袭了父类的功能，又定义了子类特有的内容
     */

    public void smallBlack(){
        super.smallBlack();
        System.out.println("说中文");
    }
}
