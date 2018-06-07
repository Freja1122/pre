import java.util.*;

/**
 * @program: Problem01449
 * @description:
 * @author: Annntn
 * @create: 2018-06-07 22:41
 **/

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            int[] du = new int[501];
            int N = cin.nextInt();
            int M = cin.nextInt();
            ArrayList<Integer> arr[] = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                int a = cin.nextInt();
                int b = cin.nextInt();
                arr[a].add(b);
                du[b]++;
            }
            for (int i = 1; i <= N; i++) {
                if (du[i] == 0) {
                    queue.offer(i);
                }
            }
            ArrayList<Integer> ans = new ArrayList<>();
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                ArrayList<Integer> culist = arr[cur];
                ans.add(cur);
                for (int i = 0; i < culist.size(); i++) {
                    int temp = culist.get(i);
                    du[temp]--;
                    if (du[temp] == 0) {
                        queue.offer(temp);
                    }
                }
            }
            for (int i = 0; i < ans.size(); i++) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(ans.get(i));
            }
            System.out.println();
        }
    }
}
