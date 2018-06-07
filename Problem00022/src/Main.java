import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Node implements Comparable<Node> {
    int start;
    int end;

    public int compareTo(Node node) {
        return end - node.end;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        Node[] nodes = new Node[100];
        while (cin.hasNextInt()) {
            int N = cin.nextInt();
            if (N == 0) {
                break;
            }
            for (int i = 0; i < N; i++) {
                nodes[i] = new Node();
                nodes[i].start = cin.nextInt();
                nodes[i].end = cin.nextInt();
            }
            Arrays.sort(nodes,0,N);
            int ans = 1;
            int curr = nodes[0].end;
            for (int i = 1; i < N; i++) {
                if (nodes[i].start>=curr){
                    ans++;
                    curr=nodes[i].end;
                }
            }
            System.out.println(ans);
        }
    }
}
