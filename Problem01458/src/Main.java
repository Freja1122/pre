import java.util.Scanner;

public class Main {
    public static long hnt(int n) {
        if (n==1){
            return 2;
        }
        else return 3*hnt(n-1)+2;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            System.out.println(hnt(n));
        }
    }

}
