import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @program: Problem061
 * @description:
 * @author: Annntn
 * @create: 2018-06-06 21:59
 **/

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextBigDecimal()) {
            BigDecimal n = cin.nextBigDecimal();
            BigDecimal ans = new BigDecimal(1);
            while (n.compareTo(new BigDecimal(1)) > 0) {
                ans=ans.multiply(n);
                n=n.subtract(new BigDecimal(1));
            }
            System.out.println(ans);
        }
    }
}
