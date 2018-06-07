import java.util.Scanner;

/**
 * @program: Problem058
 * @description:
 * @author: Annntn
 * @create: 2018-06-06 21:10
 **/

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        while (n-- != 0) {
            long a = cin.nextLong();
            long b = cin.nextLong();
            long c = cin.nextLong();
            int k = cin.nextInt();
            if (b - a == c - b) {
                System.out.println((a + ((k - 1) * (b - a)) % 200907) % 200907);
            }
            else {
                long res = a;
                int i = 1;
                long bs = b / a;
                // bs ^ (ans-1)
                int temp = k - 1;
                while (temp != 0) {
                    if (temp % 2 == 1) {
                        res *= bs;
                        res %= 200907;
                    }
                    temp /= 2;
                    bs *= bs;
                    bs %= 200907;
                }
                System.out.println(res);
            }
        }
    }
}
