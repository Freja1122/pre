import java.io.BufferedInputStream;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class CMP implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return a - b;
    }
}

public class Main {


    public static void main(String args[]) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        while (cin.hasNextInt()) {
            int N = cin.nextInt();
            CMP cmp = new CMP();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(cmp);
            for (int i = 0; i < N; i++) {
                priorityQueue.add(cin.nextInt());
            }
            int res = 0;
            while (priorityQueue.size() > 1) {
                int a = priorityQueue.poll();
                int b = priorityQueue.poll();
                res += a + b;
                priorityQueue.add(a + b);
            }
            System.out.println(res);
        }
    }
}
