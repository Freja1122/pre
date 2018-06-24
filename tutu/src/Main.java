import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @program: tutu
 * @description:
 * @author: Annntn
 * @create: 2018-06-21 19:42
 **/

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            List<Integer> arr = new ArrayList<>();
            while (n-- != 0) {
                arr.add(cin.nextInt());
            }

            List<Integer> listWithoutDup = new ArrayList<Integer>(new LinkedHashSet<Integer>(arr));

            int ans = Math.min(listWithoutDup.size(),10);
            System.out.println(ans);
            for (int i=0;i<ans;i++){
                System.out.println(listWithoutDup.get(i));
            }


        }
    }
}
