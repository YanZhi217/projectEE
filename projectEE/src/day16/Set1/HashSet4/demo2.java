package day16.Set1.HashSet4;

/**
 * 计算哈希值
 * 在JDK1.8之前，哈希表是通过数组 + 链表实现的,长度默认16，当存到16*0.75（装填因子） = 12个，则扩为两倍，通过equals方法比较属性值
 * JDK1.8之后哈希表是通过数组 + 链表（小于8个）或者数组 + 红黑树（大于8个）实现的，当同一个哈希值下存的链表元素超过8个，则改为红黑树存储
 */
public class demo2 {
    public static void main(String[] args) {
        Student s1 = new Student("xiaozhi",23);
        Student s2 = new Student("xiaomei",22);

        //因为在Object类中，是根据对象的地址值计算出来的哈希值。
        System.out.println(s1.hashCode());//1060830840
        System.out.println(s1.hashCode());//1060830840


        System.out.println(s2.hashCode());//2137211482
    }
}
