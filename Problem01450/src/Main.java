import java.util.*;

/**
 * @program: Problem01450
 * @description:
 * @author: Annntn
 * @create: 2018-06-07 23:44
 **/

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int maxn=10001;
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            if (n == 0) {
                break;
            }
            int bb=0;
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int[] du = new int[maxn];
            for (int i = 0; i < n; i++) {
                String a = cin.next();
                String b = cin.next();
                int ind1 = 0;
                int ind2 = 0;
                if (map.containsKey(a)) {
                    ind1 = map.get(a);
                } else {
                    map.put(a, bb++);
                    ind1=map.get(a);
                }
                if (map.containsKey(b)) {
                    ind2 = map.get(b);
                } else {
                    map.put(b, bb++);
                    ind2=map.get(b);
                }
                du[ind2]++;

            }
            int ans=0;
            for (int i = 0; i < map.size(); i++) {
                if (du[i] == 0) {
                    ans++;
                }
            }
            if (ans==1){
                System.out.println("Yes");
            }
             else {
                System.out.println("No");
            }

        }
    }
}
