import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int arr[] = new int[2001];
        int res[][] = new int[1001][2001];//前j个元素选择i对
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            int k = cin.nextInt();
            for (int i = 1; i <= n; i++) {
                arr[i] = cin.nextInt();
            }
            Arrays.sort(arr, 1, n + 1);
            for (int i = 1; i <= k; i++) {
                for (int j = 2 * i; j <= n; j++) {
                    //初始化要注意，第一对必须匹配，也就是
                    int temp = 0;
                    if (j > 2 * i) {
                        temp = res[i][j - 1];
                    } else {
                        temp = 123123123;
                    }
                    Math.pow(1,2);
                    res[i][j] = Math.min(temp, (int) (res[i - 1][j - 2] + ((arr[j] - arr[j - 1])*(arr[j] - arr[j - 1]))));
                }
            }
            System.out.println(res[k][n]);
        }
    }
}
