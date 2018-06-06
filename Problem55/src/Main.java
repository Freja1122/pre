import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: Problem053
 * @description:
 * @author: Annntn
 * @create: 2018-06-06 15:22
 **/

public class Main {
    static int intmax = 1010;
    static boolean[] numbers = new boolean[intmax];

    public static void main(String[] args) {
        for (int i = 2; i < intmax; i++) {
            if (numbers[i] == false) {
                if (i * i < intmax && i * i > 0) {
                    for (int j = i * i; j < intmax && j > 0; j += i) {
                        numbers[j] = true;
                    }
                }
            }
        }
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            int a = cin.nextInt();
            int[] anum = new int[intmax];
            int[] nnum = new int[intmax];
            if (n == 0 && a == 0) {
                break;
            }
            for (int i = 2; i <= n; i++) {
                if (numbers[i] == false) {
                    for (int j = 1; Math.pow(i, j) <= n; j++) {
                        nnum[i] += n / Math.pow(i, j);
                    }
                }
            }
            for (int i = 2; i <= a; i++) {
                while (numbers[i] == false && a % i == 0) {
                    anum[i]++;
                    a /= i;
                }
                if (a == 1) {
                    break;
                }
            }
            int res = 200000;
            int bound = Math.max(a, n);
            for (int i = 0; i < bound; i++) {
                if (anum[i] != 0 && nnum[i] != 0) {
                    int temp = nnum[i]/anum[i];
                    if (temp < res) {
                        res = temp;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
