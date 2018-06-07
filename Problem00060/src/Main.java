import java.math.BigInteger;
import java.util.Scanner;

/**
 * @program: Problem060
 * @description:
 * @author: Annntn
 * @create: 2018-06-06 21:51
 **/

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextBigInteger()){
            BigInteger a = cin.nextBigInteger();
            BigInteger b = cin.nextBigInteger();
            System.out.println(a.add(b));
        }
    }
}
