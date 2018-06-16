import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n = 0;
    static int m = 0;
    static int t = 0;
    static String[] mag = new String[7];//原来数据的数组
    static boolean[][] check = new boolean[7][7];//状态数组
    static int startx = 0;
    static int starty = 0;
    static boolean state = false;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//方向数组

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            n = cin.nextInt();
            m = cin.nextInt();
            t = cin.nextInt();
            Arrays.fill(check, false);
            for (int i = 0; i < n; i++) {
                mag[i] = cin.next();
                if (mag[i].indexOf('S') != -1) {
                    startx = i;
                    starty = mag[i].indexOf('S');
                }
            }
            check[startx][starty] = true;//初始状态更新
            dfs(startx, starty, 0);//开始遍历
            if (state == false) {
                System.out.println("No");
            }
        }
    }

    public static void dfs(int i, int j, int tm) {
        if (mag[i].charAt(j) == 'D') {
            if ( tm == t){
                state = true;
                System.out.println("Yes");
                return;
            }
            else return;
        }
        for (int k = 0; k < direction.length; k++) {
            int ii = i + direction[k][0];
            int jj = j + direction[k][1];
            if (ii < 0 || ii >= n || jj < 0 || jj > m || mag[ii].charAt(jj) != 'X') {
                continue;
            }//判断是否满足】
            check[ii][jj] = true;//状态更新
            dfs(ii, jj, t + 1);
            check[ii][jj] = false;//回溯状态更新
        }
    }
}
