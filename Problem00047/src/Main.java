import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @program: Problem47
 * @description:
 * @author: Annntn
 * @create: 2018-06-06 10:20
 **/

public class Main {
    public static void main(String[] args) {
        Scanner cin=new Scanner(new BufferedInputStream(System.in));
        while (cin.hasNextInt()){
            int a=cin.nextInt();
            int b=cin.nextInt();
            while (a!=0&&b!=0){
                int temp=a%b;
                a=b;
                b=temp;
            }
            int res=0;
            if (a==0){
                res=b;
            }
            else if (b==0){
                res=a;
            }
            else {
                res=0;
            }
            System.out.println(res);
        }
    }
}
