import java.util.Scanner;

/**
 * @program: Problem50
 * @description:
 * @author: Annntn
 * @create: 2018-06-06 13:58
 **/

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            String res="yes";
            int bound = (int)Math.sqrt(n)+1;//计算枚举上界，放置double值带来的精度损失，采用根号值取整吼再加1，宁愿多枚举一个值。
            for (int i = 2; i <= bound; i++) {
                if (n % i == 0) {
                    res="no";
                }
            }
            if (n==1){
                res="no";
            }
            System.out.println(res);
        }
    }
}
