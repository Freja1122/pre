import java.util.*;

class Node implements Comparable<Node> {
    String name;
    int weight;
    Node(String j, int we) {
        name = j;
        weight = we;
    }
    public int compareTo(Node node) {
        return node.weight - weight;
    }
}

class Nodes {
    int max1 = 1001;
    int[] father = new int[max1];
    Node[] nodes = new Node[max1];
    int[] sum = new int[max1];
    Map<Integer, ArrayList<Node>> gang = new HashMap<>();
    int size = 1;

    public void insert(String name, int i, int num) {
        if (gang.containsKey(i)) {
            nodes[i].weight += num;
        } else {
            Node node = new Node(name, num);
            nodes[i] = node;
            father[i] = -1;
            gang.put(i, new ArrayList<>());
            gang.get(i).add(node);
        }
    }

    public void merge(String a, String b, int weight) {
        int i = a.charAt(0) - 'A' + 1;
        int j = b.charAt(0) - 'A' + 1;
        if (i == j) {
            return;
        }
        insert(a, i, weight);
        insert(b, j, weight);
        int root1 = findFather(i);
        int root2 = findFather(j);

        if (root1 != root2) {
            father[root2] = root1;
            sum[root1] += sum[root2];
            gang.get(root1).addAll(gang.get(root2));
        }
        sum[root1] += weight;
    }

    int findFather(int i) {
        if (father[i] == -1) {
            return i;
        }
        int temp = findFather(father[i]);
        father[i] = temp;
        return temp;
    }


    public int findbigger(int total) {
        int flag = 0;
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 1; i < max1; i++) {
            if (father[i] == -1) {
                ArrayList<Node> temp = gang.get(i);
                int len = temp.size();
                if (len > 2 && sum[i] > total) {
                    flag += 1;
                    Collections.sort(temp);
                    strings.add(temp.get(0).name + " " + len + "\n");
                }
            }
        }
        Collections.sort(strings);
        if (flag == 0) {
            System.out.println(0);
        } else {
            System.out.println(flag);
            for (String s:strings) {
                System.out.print(s);
            }
        }
        return 0;
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
                nodes.merge(a, b, cin.nextInt());
            }
            nodes.findbigger(total);
        }
    }
}
