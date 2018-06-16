import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        long[] res = new long[21];
        res[1]=0;
        res[2]=1;
        for (int i = 3; i <= 20; i++) {
            res[i]=res[i-1]*(i-1)+res[i-2]*(i-1);
        }
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            System.out.println(res[n]);
        }
    }
}
