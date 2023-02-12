package day4;

public class shortcut1 {
    /*
        psvm + 回车 : 快速生成main方法
        sout + 回车 : 快速生成输出语句

        alt + 1 : 打开 \ 隐藏 工程目录结构
        alt + 4 : 打开 \ 隐藏 控制台
    */
    public static void main(String[] args) {
        System.out.println("alt+1:打开或隐藏工程目录结构");
        System.out.println("alt+4:打开或隐藏控制台");

        /*
            Ctrl + alt + L          格式化代码
            Ctrl + alt + v          快速生成方法的返回值
            Alt + enter            代码修正提示
            Ctrl + D                向下复制一行
            Ctrl + X                剪切当前行
            Ctrl + /                批量加入单行注释，再按一次就是取消
            Ctrl + shift + /        批量加入多行注释，再按一次就是取消
            Alt + shift + ↑         上移当前行
            Alt + shift + ↓         下移当前行
        */
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        int c = 10;
        System.out.println(c);
    }
}
