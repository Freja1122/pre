import java.util.Scanner;

/**
 * @program: 03_FindInPartiallySortedMatrix
 * @description:
 * @author: Annntn
 * @create: 2018-06-29 22:35
 **/

public class Main {
    static int[][] arr = new int[20][20];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int m = cin.nextInt();
            int n = cin.nextInt();
            int test = cin.nextInt();
            if (m == 0 || n == 0) {
                break;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = cin.nextInt();
                    if (i != 0) {
                        if (arr[i][j] < arr[i - 1][j]) {
                            System.out.println("not sorted");
                        }
                    }
                    if (j != 0) {
                        if (arr[i][j] < arr[i][j - 1]) {
                            System.out.println("not sorted");
                        }
                    }
                }
            }
            for (int i = 0; i < test; i++) {
                int t = cin.nextInt();
                if (find(m - 1, n - 1, t) != 0) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }

        }
    }

    public static int find(int row, int columns, int t) {
        if (row < 0 || columns < 0) {
            return 0;
        }
        if (arr[columns][row] == t) {
            return 1;
        }
        if (arr[columns][row] > t) {
            columns--;
            return find(row, columns, t);
        }
        if (arr[columns][row] < t) {
            row--;
            return find(row, columns, t);
        }
        return 0;
    }
}
