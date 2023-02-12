package day5;

public class method6 {
        /*
                方法重载：
                需求：使用方法重载的思想，设计比较两个整数是否相同的方法，兼容全整数类型（byte,short,int,long）
                方法重载指同一个类中定义的多个方法之间的关系，满足下列条件的多个方法相互构成重载
                多个方法在同一个类中
                多个方法具有相同的方法名
                多个方法的参数不相同，类型不同或者数量不同

                重载仅对应方法的定义，与方法的调用无关，调用方式参照标准格式
                重载仅针对同一个类中方法的名称与参数进行识别，与返回值无关，换句话说不能通过返回值来判定两个方法是否相互构成重载
        */
        public static void main(String[] args) {
            short a = 10;
            short b = 20;
            System.out.println(compare(a,b));
        }

        public static boolean compare (int a, int b){
            return a == b;
        }

        public static boolean compare (byte a, byte b){
            return a == b;
        }

        public static boolean compare (short a, short b){
            return a == b;
        }

        public static boolean compare (long a, long b){
            return a == b;
        }
}
