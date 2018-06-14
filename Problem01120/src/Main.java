import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String str = "";
    static boolean[] check = new boolean[6];
    static char[] chars = new char[8];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            str = cin.next();
            chars = str.toCharArray();
            Arrays.fill(check, false);
            Arrays.sort(chars);
            StringBuilder s = new StringBuilder();
            bfs(s);
            System.out.println();
        }
    }

    public static void bfs(StringBuilder s) {
        if (s.length()==chars.length){
            System.out.println(s);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (check[i]==false){
                check[i]=true;
                s.append(chars[i]);
                bfs(s);
                s.deleteCharAt(s.length()-1);
                check[i]=false;
            }
        }
    }
}
