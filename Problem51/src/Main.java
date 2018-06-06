import java.util.Scanner;

/**
 * @program: Problem51
 * @description:
 * @author: Annntn
 * @create: 2018-06-06 14:10
 **/

public class Main {
    static boolean numbers[] = new boolean[10010];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int len = numbers.length;
        for (int i = 2; i < len; i++) {
            if (numbers[i] == false) {
                for (int j = 2; j * i < len; j++) {
                    numbers[j * i] = true;
                }
            }
        }
        while (cin.hasNextInt()) {
            int flag = 0;
            int n = cin.nextInt();
            for (int i = 2; i < n; i++) {
                if (i % 10 == 1 && numbers[i] == false) {
                    if (flag == 1) {
                        System.out.print(' ');
                    }
                    flag = 1;
                    System.out.print(i);
                }
            }
            if (flag == 0) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
