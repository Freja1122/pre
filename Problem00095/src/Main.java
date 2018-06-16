import java.util.Scanner;

public class Main {
    static int[] list = new int[26];
    static int[] res = new int[26];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()){
            int n = cin.nextInt();
            for (int i = 0; i < n; i++) {
                list[i] = cin.nextInt();
                int max=1;
                for (int j = 0; j < i; j++) {//从0开始
                    if (list[j]>=list[i]){//方向看清楚
                        max=Math.max(max,res[j]+1);
                    }
                }
                res[i]=max;
            }
            int max=0;
            for (int i = 0; i < n; i++) {
                max=Math.max(max,res[i]);
            }
            System.out.println(max);
        }
    }
}
