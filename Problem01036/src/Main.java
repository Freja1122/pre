import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            int res = 0;
            for (int i = 1000; i > 1; i /= 10) {
                int a = cin.nextInt();
                res += a * i;
            }
            int flag = 0;
            for (int i = 9; i > 0; i--) {
                for (int j = 9; j >= 0; j--) {
                    int temp = res + i * 10000 + j;
                    if (temp % n == 0) {
                        flag = 1;
                        System.out.println(i + " " + j + " " + temp / n);
                        break;
                    }
                }
                if (flag==1){
                    break;
                }
            }
            if (flag == 0) {
                System.out.println(0);
            }
        }
    }
}
