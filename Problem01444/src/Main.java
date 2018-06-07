import java.lang.reflect.Array;
import java.util.*;


class Nodes {
    int max1 = 1000001;
    int[] nodes = new int[max1];
    int[] num = new int[max1];


    public void merge(int i, int j) {
        if (i==j){
            return;
        }
        int root1 = findroot(i);
        int root2 = findroot(j);
        if (num[root1] == 0) {
            num[root1]++;
        }
        if (num[root2] == 0) {
            num[root2]++;
        }
        if (root1 != root2) {
            nodes[root2] = root1;
            num[root1] += num[root2];
        }
    }

    public int findroot(int i) {
        if (nodes[i] == 0) return i;
        int temp = findroot(nodes[i]);
        nodes[i]=temp;
        return temp;
    }

    public int findmax() {
        Arrays.sort(num);
        return num[max1-1];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            Nodes nodes = new Nodes();
            for (int i = 0; i < n; i++) {
                nodes.merge(cin.nextInt(), cin.nextInt());
            }
            System.out.println(Math.max(1,nodes.findmax()));
        }
    }
}
