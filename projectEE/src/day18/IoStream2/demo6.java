package day18.IoStream2;

import java.io.FileOutputStream;
import java.io.IOException;
public class demo6 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            //System.out.println(2/0);
            fos = new FileOutputStream("D:\\develop\\projectEE\\a.txt",true);
            fos.write(97);
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            //finally语句里面的代码,一定会被执行.
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
