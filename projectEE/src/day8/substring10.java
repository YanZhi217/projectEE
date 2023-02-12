package day8;

public class substring10 {
    /*
        截取字符串:
            String substring(int beginIndex) :
                   从传入的索引位置处，向后截取，一直截取到末尾，得到新的字符串并返回
            String substring(int beginIndex, int endIndex) ：
                   从beginIndex索引位置开始截取，截取到endIndex索引位置，得到新字符串并返回（包含头，不包含尾）
    */
    public static void main(String[] args) {
        String s = "itheima";
        String ss = s.substring(2);
        System.out.println(ss);

        String sss = s.substring(0,2);
        System.out.println(sss);

    }

}
