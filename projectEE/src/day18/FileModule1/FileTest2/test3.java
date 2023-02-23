package day18.FileModule1.FileTest2;

import java.io.File;
import java.util.HashMap;

public class test3 {
    public static void main(String[] args) {
        //统计一个文件夹中,每种文件出现的次数.
        //统计 --- 定义一个变量用来统计. ---- 弊端:同时只能统计一种文件
        //利用map集合进行数据统计,键 --- 文件后缀名  值 ----  次数

        File file = new File("D:\\develop\\projectEE");
        HashMap<String, Integer> hm = new HashMap<>();
        getCount(hm, file);
        System.out.println(hm);
    }

    private static void getCount(HashMap<String, Integer> hm, File file) {
        File[] files = file.listFiles();

        if (files != null) {
                for (File f : files) {
                    //判断是文件还是文件夹
                    if(f.isFile()){
                            //获取路径下的文件或文件夹名
                            String fileName = f.getName();
                            //按照"."的方式进行分割并保存到一个String数组中
                            String[] fileNameArr = fileName.split("\\.");
                            //判断文件名是否是 类似“a.a”的格式
                            if(fileNameArr.length == 2){
                                //获取后缀
                                String fileEndName = fileNameArr[1];
                                //判断后缀名是否已经在集合中出现过
                                    if(hm.containsKey(fileEndName)){
                                        //已经存在
                                        //将已经出现的次数获取出来
                                        Integer count = hm.get(fileEndName);
                                        //这种文件又出现了一次.
                                        count++;
                                        //把已经出现的次数给覆盖掉.
                                        hm.put(fileEndName,count);
                                    } else{
                                        //不存在
                                        //表示当前文件是第一次出现
                                        hm.put(fileEndName,1);
                                    }
                            //解决文件夹名中有1个"."导致生成null在fileNameArr中
                            }else if (fileNameArr.length == 3) {
                                String[] newFileNameArr = new String[2];
                                newFileNameArr[0] = fileNameArr[0];
                                newFileNameArr[1] = fileNameArr[2];

                                String fileEndName = newFileNameArr[1];

                                    if(hm.containsKey(fileEndName)){
                                        //已经存在
                                        //将已经出现的次数获取出来
                                        Integer count = hm.get(fileEndName);
                                        //这种文件又出现了一次.
                                        count++;
                                        //把已经出现的次数给覆盖掉.
                                        hm.put(fileEndName,count);
                                    } else{
                                        //不存在
                                        //表示当前文件是第一次出现
                                        hm.put(fileEndName,1);
                                    }
                            }
                    }else{
                        //如果是文件夹则递归调用此方法
                        getCount(hm,f);
                    }
                }
        }else{
            System.out.println("文件夹为空");
        }

    }
}
