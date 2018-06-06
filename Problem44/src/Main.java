import java.io.BufferedInputStream;
import java.util.*;

public class Main {
    public static HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();

    public static void main(String[] args) {
        initmap();
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        while (cin.hasNextInt()) {
            int a = cin.nextInt();
            String n = cin.next();
            int b = cin.nextInt();
            System.out.println(toint(n, a, b));
        }
    }

    public static void initmap() {
        for (int i = 0; i < 10; i++) {
            characterIntegerHashMap.put((char) ('0' + i), i);
        }
        for (int i = 0; i < 6; i++) {
            characterIntegerHashMap.put((char) ('A' + i), i + 10);
        }
        for (int i = 0; i < 6; i++) {
            characterIntegerHashMap.put((char) ('a' + i), i + 10);
        }
    }

    public static String toint(String n, int a, int b) {
        long ans = 0;
        int len = n.length();
        for (int i = 0; i < n.length(); i++) {
            ans += characterIntegerHashMap.get(n.charAt(len - i - 1)) * Math.pow(a, i);
        }
        List<Long> res = new ArrayList<>();
        do {
            res.add(ans % b);
            ans/=b;
        }while (ans != 0);
        int size = res.size();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            long temp = res.get(size - i - 1);
            Character ch;
            if (temp >= 10) {
                ch = (char) ('A' + (temp - 10));
            } else {
                ch = (char)('0'+temp);
            }
            str.append(ch);
        }
        return str.toString();
    }
}
