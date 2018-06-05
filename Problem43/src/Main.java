import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @program: Problem43
 * @description:
 * @author: Annntn
 * @create: 2018-06-05 16:29
 **/

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        while (cin.hasNextInt()) {
            int M = cin.nextInt();
            if (M == 0) {
                break;
            }
            long a = cin.nextLong();
            long b = cin.nextLong();
            long res = a + b;
            StringBuilder buf = new StringBuilder();
            while (res != 0) {
                buf.append((int) (res % M));
                res /= M;
            }
            buf.reverse();
            if (buf.length()==0) {
                System.out.println(0);
            }
            else{
                System.out.println(buf);
            }
        }
    }
}
