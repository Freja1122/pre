import java.math.BigInteger;
import java.util.Scanner;

/**
 * @program: Problem062
 * @description:
 * @author: Annntn
 * @create: 2018-06-06 22:15
 **/

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            BigInteger a = cin.nextBigInteger(10);
            int N = cin.nextInt();
            System.out.println(a.toString(N).toUpperCase());

        }
    }
}
