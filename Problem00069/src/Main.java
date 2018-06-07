import java.util.Scanner;

/**
 * @program: Problem00069
 * @description:
 * @author: Annntn
 * @create: 2018-06-07 10:49
 **/
class Node {
    int max1 = 0;
    int[] nodes = new int[1001];

    Node(int max2) {
        max1 = max2+1;
    }

    public void merge(int i, int j) {
        if (i != j) {
            int r1 = findroot(i);
            int r2 = findroot(j);
            if (r1 != r2) {
                nodes[r1] = r2;
            }
        }
    }

    public int findroot(int i) {
        if (nodes[i] == 0) {
            return i;
        }
        int temp = findroot(nodes[i]);
        nodes[i] = temp;
        return temp;
    }

    public int findnum() {
        int res = 0;
        for (int i = 1; i < max1; i++) {
            if (nodes[i] == 0) {
                res++;
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        for (int i = 0; i < T; i++) {
            int N = cin.nextInt();
            int M = cin.nextInt();
            Node node = new Node(N);
            for (int j = 0; j < M; j++) {
                node.merge(cin.nextInt(), cin.nextInt());
            }
            System.out.println(node.findnum());
        }
    }
}
