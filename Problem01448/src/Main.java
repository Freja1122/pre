import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @program: Problem01448
 * @description:
 * @author: Annntn
 * @create: 2018-06-07 22:22
 **/


public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            ArrayList<Integer> arr[] = new ArrayList[101];
            Queue<Integer> noin = new LinkedList<>();
            int[] du = new int[101];
            int N = cin.nextInt();
            int M = cin.nextInt();
            if (N == 0) {
                break;
            }
            for (int i = 0; i < N; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                int a = cin.nextInt();
                int b = cin.nextInt();
                du[b]++;
                arr[a].add(b);
            }
            for (int i = 0; i < N; i++) {
                if (du[i] == 0) {
                    noin.offer(i);
                }
            }
            int ans = 0;
            while (!noin.isEmpty()) {
                int temp = noin.poll();
                ans++;
                for (int i = 0; i < arr[temp].size(); i++) {
                    int de = arr[temp].get(i);
                    du[de]--;
                    if (du[de] == 0) {
                        noin.offer(de);
                    }
                }
            }
            if (ans == N) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
