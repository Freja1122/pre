import java.util.Scanner;

/**
 * @program: Problem10101
 * @description:
 * @author: Annntn
 * @create: 2018-06-16 15:41
 **/
class Mat {
    int time;
    int value;

    Mat(int time, int value) {
        this.time = time;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            Mat[] mats = new Mat[101];//保存原来的数组
            int[][] dp = new int[101][1001];//保存dp结果
            int time = cin.nextInt();
            int n = cin.nextInt();
            for (int i = 1; i <= n; i++) {
                mats[i] = new Mat(cin.nextInt(), cin.nextInt());
            }
            //遍历所有元素，考虑加入和不加入
            for (int i = 1; i <= n; i++) {
                //遍历所有可能的价值，从0到time都需要考虑
                for (int j = 1; j <= time; j++) {
                    //如果当前可以加入，则比较加入和不加入的大小，取大值
                    if (j - mats[i].time >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - mats[i].time] + mats[i].value);
                    } else {
                        //否则只能不加入
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            System.out.println(dp[n][time]);
        }
    }
}
