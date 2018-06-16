
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        int tt = 0;
        int offset = 2000;//平衡负数
        while (tt++ != t) {//傻了
            int n = cin.nextInt();
            int[] arr = new int[101];//保存101个结果
            int[][] res = new int[101][4001];//保存选取前i个，a和b两堆差值为j的总重量
            int zero = 0;//保存结果中是否有0
            for (int i = 1; i <= n; i++) {
                arr[i] = cin.nextInt();
                if (arr[i] == 0) {
                    zero = 1;
                }
            }

            for (int i = -2000; i <= 2000; i++) {
                res[0][i + offset] = Integer.MIN_VALUE;
            }
            res[0][offset] = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = -2000; j <= 2000; j++) {//遍历所有可能的差值
                    int r1 = Integer.MIN_VALUE, r2 = Integer.MIN_VALUE;
                    //当前差值可能是上一次减过来的，并且上一次存在
                    int il = j + arr[i] + offset;
                    if (il >= 0 && il <= 4000 && res[i - 1][il] != Integer.MIN_VALUE) {
                        r1 = res[i - 1][il] + arr[i];
                    }
                    int ir = j - arr[i] + offset;
                    //当前差值可能是上一次加过来的，并且上一次存在
                    if (ir >= 0 && ir <= 4000 && res[i - 1][ir] != Integer.MIN_VALUE) {
                        r2 = res[i - 1][ir] + arr[i];
                    }
                    int max = Math.max(r1, r2);
                    res[i][j + offset] = Math.max(
                            max,
                            res[i - 1][j + offset]
                    );
                }
            }
            System.out.print("Case " + tt + ": ");
            if (res[n][offset] != 0) {
                System.out.println(res[n][offset] / 2);
            } else {
                if (zero == 1) {
                    System.out.println(0);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
