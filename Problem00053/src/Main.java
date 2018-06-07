import java.util.Scanner;

/**
 * @program: Problem053
 * @description:
 * @author: Annntn
 * @create: 2018-06-06 15:22
 **/

public class Main {
    static int intmax = 40000;
    static boolean[] numbers = new boolean[intmax];

    public static void main(String[] args) {
        for (int i = 2; i < intmax; i++) {
            if (numbers[i] == false) {
                if (i * i < intmax && i * i > 0) {
                    for (int j = i * i; j < intmax && j > 0; j+=i) {
                        numbers[j] = true;
                    }
                }
            }
        }
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            int ans = 0;
            for (int i = 2; i <= n / 2; i++) {
                if (numbers[i] == false && numbers[n - i] == false) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
