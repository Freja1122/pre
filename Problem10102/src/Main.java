import java.util.Arrays;
import java.util.Scanner;

class Mat {
    int w;
    int v;

    Mat(int v, int w) {
        this.w = w;
        this.v = v;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while (t-- != 0) {
            Mat[] mats = new Mat[501];
            int[] dp = new int[10001];
            int s = -(cin.nextInt() - cin.nextInt());
            int n = cin.nextInt();
            for (int i = 1; i <= n; i++) {
                mats[i] = new Mat(cin.nextInt(), cin.nextInt());
            }
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = mats[i].w; j <= s; j++) {
                    if (dp[j - mats[i].w] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j - mats[i].w] + mats[i].v);
                    }
                }
            }
            if (dp[s] == Integer.MAX_VALUE) {
                System.out.println("This is impossible.");
            } else {
                System.out.println("The minimum amount of money in the piggy-bank is " + dp[s] + ".");
            }
        }
    }
}
