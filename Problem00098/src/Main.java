import java.util.Scanner;

/**
 * @program: Problem00098
 * @description:
 * @author: Annntn
 * @create: 2018-06-15 10:47
 **/

public class Main {
    static String s1 = "";
    static String s2 = "";
    static int n = 0;
    static int m = 0;
    static int[][] dp = new int[102][102];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            s1 = '#'+cin.next();//注意#开头
            s2 = '#'+cin.next();
            n = s1.length();
            m = s2.length();
            int max = 0;
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (s1.charAt(i)==s2.charAt(j)){
                        dp[i][j] = dp[i-1][j-1]+1;
                    }
                    else{
                        dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                    }
                    if (dp[i][j]>max){
                        max = dp[i][j];
                    }
                }
            }
            System.out.println(max);
        }
    }
}
