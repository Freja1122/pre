import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()){
            int n = cin.nextInt();
            System.out.println(getRes(n));
        }
    }
    public static int getRes(int n){
        if (n==0)return 1;
        if (n==1)return 1;
        return getRes(n-1)+getRes(n-2);
    }
}
