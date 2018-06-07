import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int[][] arr = new int[1001][1001];
        while (cin.hasNextInt()) {
            int N = cin.nextInt();
            int M = cin.nextInt();
            if (N == 0 && M == 0) {
                continue;
            }
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= N; j++) {
                    arr[i][j] = -1;
                }
            }
            for (int i = 0; i < M; i++) {
                int a = cin.nextInt();
                int b = cin.nextInt();
                int we = cin.nextInt();
                arr[a][b] = we;
                arr[b][a] = we;
            }
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (arr[i][k - 1] == -1 || arr[k - 1][j] == -1) {
                            continue;
                        } else if (arr[i][j] == -1 || arr[i][k - 1] + arr[k - 1][j] < arr[i][j]) {
                            arr[i][j] = arr[i][k - 1] + arr[k - 1][j];
                        }
                    }
                }
            }
            System.out.println(arr[1][N]);
        }
    }
}
