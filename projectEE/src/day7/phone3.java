package day7;

public class phone3 {
    // 品牌, 价格
    String brand;
    int price;

    // 打电话, 发短信
    public void call(String name){
        System.out.println("给"+name+"打电话");
    }

    public void sendMessage(){
        System.out.println("群发短信");
    }
}
