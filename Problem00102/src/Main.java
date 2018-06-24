import java.util.Arrays;
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

    Mat(int value,int time) {
        this.time = time;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while (t-- != 0) {
            Mat[] mats = new Mat[501];//保存原来的数组
            int[] dp = new int[10001];//保存dp结果
            int a = cin.nextInt();
            int b = cin.nextInt();
            int time = b - a;
            int n = cin.nextInt();
            for (int i = 1; i <= n; i++) {
                mats[i] = new Mat(cin.nextInt(), cin.nextInt());
            }
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            //遍历所有元素，考虑加入和不加入
            for (int i = 1; i <= n; i++) {
                //遍历所有可能的价值，从0到time都需要考虑
                for (int j = mats[i].time; j <= time; j++) {
                    if (dp[j - mats[i].time]!=Integer.MAX_VALUE){
                        dp[j] = Math.min(dp[j], dp[j - mats[i].time] + mats[i].value);
                    }
                }
            }
            if (dp[time] == Integer.MAX_VALUE) {
                System.out.println("This is impossible.");
            } else {
                System.out.println("The minimum amount of money in the piggy-bank is " + dp[time] + ".");
            }
        }
    }
}
