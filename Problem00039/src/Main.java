import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        while (cin.hasNext()) {
            String a = cin.next();
            String b = cin.next();
            int ans=0;
            for (int i = 0; i < a.length(); i++) {
                for (int j = 0; j < b.length(); j++) {
                    ans+=(a.charAt(i)-'0')*(b.charAt(j)-'0');
                }
            }
            System.out.println(ans);
        }
    }
}
