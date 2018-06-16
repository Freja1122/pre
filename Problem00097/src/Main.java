import java.util.Scanner;

public class Main {
    static int[] arr = new int[101];
    static int[] res = new int[101];
    static int[] res1 = new int[101];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            for (int i = 0; i < n; i++) {
                arr[i] = cin.nextInt();
                res[i] = 0;
                res1[i] = 0;
            }
            for (int i = 0; i < n; i++) {
                int max = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {//等号
                        max = Math.max(max, res[j]+1);//加一
                    }
                }
                res[i] = max;
            }
            for (int i = n - 1; i >= 0; i--) {
                int max = 1;
                for (int j = n - 1; j > i; j--) {
                    if (arr[i] > arr[j]) {
                        max = Math.max(max,res1[j]+1);//不要用混
                    }
                }
                res1[i] = max;
            }
            int max=0;
            for (int i = 0; i < n; i++) {
                max=Math.max(max,res[i]+res1[i]);
            }
            System.out.println(n-max+1);
        }
    }
}
