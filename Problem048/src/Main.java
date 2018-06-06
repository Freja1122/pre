import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin=new Scanner(new BufferedInputStream(System.in));
        while (cin.hasNextInt()){
            int a=cin.nextInt();
            int b=cin.nextInt();
            System.out.println(a*b/gcd(a,b));
        }
    }
    public static int gcd(int a,int b){
        while (b!=0){
            int t=a%b;
            a=b;
            b=t;
        }
        if (a==0){
            a=1;
        }
        return a;
    }
}
