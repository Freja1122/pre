import java.util.Scanner;

/**
 * @program: Problem053
 * @description:
 * @author: Annntn
 * @create: 2018-06-06 15:22
 **/

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            if (a==0&&b==0){
                break;
            }
            int res = 1;
            while (b != 0) {
                if (b % 2 == 1) {
                    res *= a;
                    res %= 1000;
                }
                b /= 2;
                a *= a;
                a %= 1000;
            }
            System.out.println(res);
        }
    }
}
