package day3;

public class continue15 {
    /*
		continue : 跳过某次循环体内容的执行
		注意：使用是基于条件控制, 在循环内部使用.
		需求: 模拟电梯上行的过程 1-24层, 4层不停.
	*/
    public static void main(String[] args){
        for(int i = 1; i <= 24; i++){
            if(i == 4){
                continue;
            }
            System.out.println(i + "层到了~");
        }

        /*
		break : 终止循环体内容的执行
		注意：使用是基于条件控制的
				break语句只能在循环和switch中进行使用.

		需求: 模拟20岁工作到80岁, 60岁退休.
	*/
            for(int i = 20; i <= 80; i++){
                if(i == 60){
                    break;		// 结束整个循环
                }
                System.out.println(i + "岁正在上班");
            }
    }
}
