import java.util.*;

class Node implements Comparable<Node> {
    String name;
    int weight;

    Node(String na, int we) {
        name = na;
        weight = we;
    }

    public int compareTo(Node node) {
        return node.weight - weight;
    }
}

class Nodes {
    int maxn = 30;
    int[] sum = new int[maxn];
    int[] father = new int[maxn];
    Node[] nodes = new Node[maxn];
    Map<Integer, ArrayList<Node>> ind = new HashMap<>();

    public void insert(String a, int i, int we) {
        if (ind.containsKey(i)) {
            nodes[i].weight += we;
        } else {
            Node node = new Node(a, we);
            node.weight = we;
            nodes[i] = node;
            father[i] = -1;
            ind.put(i,new ArrayList<Node>());
            ind.get(i).add(node);
        }
    }

    public void merge(String a, String b, int weight) {
        int i = a.charAt(0) - 'A' + 1;
        int j = b.charAt(0) - 'A' + 1;
        insert(a, i, weight);
        insert(b, j, weight);
        int r1 = findRoot(i);
        int r2 = findRoot(j);
        if (r1 != r2) {
            father[r2] = r1;
            sum[r1] += sum[r2];
            ind.get(r1).addAll(ind.get(r2));
        }
        sum[r1] += weight;
    }

    public int findRoot(int c) {
        if (father[c] == -1) {
            return c;
        } else {
            int temp = findRoot(father[c]);
            father[c] = temp;
            return temp;
        }
    }

    public void findHeader(int total) {
        ArrayList<String> strings = new ArrayList<String>();
        for (int i = 1; i < maxn; i++) {
            if (father[i] == -1) {
                ArrayList<Node> temp = ind.get(i);
                int len = temp.size();
                if (len > 2 && sum[i] > total) {
                    Collections.sort(temp);
                    strings.add(temp.get(0).name + " " + len);
                }
            }
        }
        Collections.sort(strings);
        System.out.println(strings.size());
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            int total = cin.nextInt();
            Nodes nodes = new Nodes();
            for (int i = 0; i < n; i++) {
                String a = cin.next();
                String b = cin.next();
                int weight = cin.nextInt();
                nodes.merge(a, b, weight);
            }
            nodes.findHeader(total);
        }
    }
}
