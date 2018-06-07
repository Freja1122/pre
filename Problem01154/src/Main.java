import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int a, b;
    int weight;

    Edge(int a, int b, int weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public int compareTo(Edge edge) {
        return weight - edge.weight;
    }
}

public class Main {
    static int[] father = new int[28];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            List<Edge> edges = new ArrayList<>();
            int N = cin.nextInt();
            if (N == 0) {
                break;
            }
            for (int i = 0; i < N; i++) {
                father[i] = -1;
            }
            for (int i = 0; i < N - 1; i++) {
                char al = cin.next().charAt(0);
                int m = cin.nextInt();
                for (int j = 0; j < m; j++) {
                    char bl = cin.next().charAt(0);
                    int weight = cin.nextInt();
                    Edge edge = new Edge(al - 'A', bl - 'A', weight);
                    edges.add(edge);
                }
            }
            Collections.sort(edges);
            int ind = 0;
            int ans = 0;
            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                if (merge(edge.a, edge.b)) {
                    ans += edge.weight;
                }
            }
            System.out.println(ans);
        }
    }

    public static boolean merge(int i, int j) {
        if (i == j) {
            return false;
        }
        int r1 = findRoot(i);
        int r2 = findRoot(j);
        if (r1 != r2) {
            father[r2] = r1;
            return true;
        }
        return false;
    }

    public static int findRoot(int i) {
        if (father[i] == -1) return i;
        int temp = findRoot(father[i]);
        father[i] = temp;
        return temp;
    }
}
