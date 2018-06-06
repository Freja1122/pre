import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        int[] buf1 = new int[10];
        int[] buf2 = new int[10];
        int size1 = 0;
        int size2 = 0;
        while (cin.hasNextInt()) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            while (a != 0) {
                buf1[size1++] = a % 10;
                a = a / 10;
            }
            while (b != 0) {
                buf2[size2++] = b % 10;
                b = b / 10;
            }
            int ans = 0;
            for (int i = 0; i < size1; i++) {
                for (int j = 0; j < size2; j++) {
                    ans += buf1[i] * buf2[j];
                }
            }
            System.out.println(ans);
        }
    }
}
