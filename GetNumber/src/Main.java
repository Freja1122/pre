import java.util.*;

/**
 * @program: GetNumber
 * @description:
 * @author: Annntn
 * @create: 2018-06-21 19:52
 **/

public class Main {
    static int[] arr = new int[11];
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            list1.clear();
            List<Integer> list = new ArrayList<>();
            int[][] dp = new int[11][101];
            for (int i = 1; i <= n; i++) {
                arr[i] = cin.nextInt();
            }
            SumOfkNumber(100,n);
        }
    }

    static List<Integer> list1 = new ArrayList<>();

    public static void SumOfkNumber(int sum, int ind) {
        if (ind <= 0 || sum <= 0)
            return;
        // 输出找到的结果
        if (sum == arr[ind]) {
            list1.add(ind);
            System.out.println(list1.size());
            // 反转list
            Collections.reverse(list1);
            for (int i = 0; i < list1.size(); i++) {
                System.out.println(list1.get(i));
            }
            return;
        }
        int size = list1.size();
        list1.add(ind);
        SumOfkNumber(sum-arr[ind],ind-1);
        list1.remove(size);
        SumOfkNumber(sum, ind-1);
    }
}
