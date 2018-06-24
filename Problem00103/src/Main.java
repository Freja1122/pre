import java.util.Scanner;

class Mat {
    int w;
    int v;

    Mat(int w, int v) {
        this.w = w;
        this.v = v;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while (t-- != 0) {
            Mat[] mats = new Mat[501];//粗暴的2001
            int[] dp = new int[101];
            int n = cin.nextInt();
            int m = cin.nextInt();
            int cnt = 1;
            for (int i = 1; i <= m; i++) {
                int w = cin.nextInt();
                int v = cin.nextInt();
                Mat mat = new Mat(w, v);
                int c = cin.nextInt();
                int k = 1;//从2的幂数字中拆分
                while (c - k > 0) {
                    mats[cnt++] = new Mat(mat.w * k, mat.v * k);
                    c -= k;//保证总和不大于该数
                    k *= 2;//先减后加
                }
                mats[cnt++] = new Mat(mat.w * c, mat.v * c);//把分组后剩下的部分加上
            }
            cnt--;
            for (int i = 1; i <= cnt; i++) {
                for (int j = n; j >= mats[i].w; j--) {//倒序
                    dp[j] = Math.max(dp[j], dp[j - mats[i].w] + mats[i].v);
                }
            }
            System.out.println(dp[n]);
        }
    }
}
