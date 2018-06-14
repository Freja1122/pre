import java.util.Scanner;

public class Main {
    static int m;
    static int n;
    static String[] arr = new String[101];
    static boolean[][] check = new boolean[101][101];
    static int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            m = cin.nextInt();
            n = cin.nextInt();
            if (m == 0) {
                break;
            }
            for (int i = 0; i < m; i++) {
                arr[i] = cin.next();
                for (int j = 0; j < n; j++) {
                    check[i][j] = false;
                }
            }
            System.out.println(getRes());
        }
    }

    public static int getRes() {
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] == false && arr[i].charAt(j) == '@') {
                    res++;
                    bfs(i, j);
                }
            }
        }
        return res;
    }

    public static void bfs(int i, int j) {
        if (i>=m||i<0||j>=n||j<0){
            return;
        }
        if (check[i][j] == false && arr[i].charAt(j) == '@') {
            check[i][j] = true;
            for (int k = 0; k < direction.length; k++) {
                bfs(i + direction[k][0], j + direction[k][1]);
            }
        } else return;
    }
}
