import java.util.ArrayList;
import java.util.Scanner;

class Node {
    int name;
    int weight;

    Node(int name, int weight) {
        this.name = name;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int[] dis = new int[101];
            boolean[] K = new boolean[101];
            ArrayList<Node> connection[] = new ArrayList[101];
            int N = cin.nextInt();
            int M = cin.nextInt();
            if (N == 0 && M == 0) {
                break;
            }
            for (int i = 0; i <= N; i++) {
                connection[i] = new ArrayList<>();
                dis[i] = -1;
            }
            for (int i = 0; i < M; i++) {
                int a = cin.nextInt();
                int b = cin.nextInt();
                int w = cin.nextInt();
                connection[a].add(new Node(b, w));
                connection[b].add(new Node(a, w));
            }
            K[1] = true;
            dis[1] = 0;
            int curr = 1;
            int num = 1;
            while (num < N) {//再加入N-1个点
                ArrayList<Node> temp = connection[curr];
                int len = temp.size();
                for (int i = 0; i < len; i++) {
                    if (K[temp.get(i).name]==true){
                        continue;
                    }
                    if (dis[temp.get(i).name] == -1 || dis[temp.get(i).name] > dis[curr] + temp.get(i).weight) {
                        dis[temp.get(i).name] = dis[curr] + temp.get(i).weight;//加的是经过的路径
                    }
                }
                int minn = 123123123;
                for (int i = 1; i <= N; i++) {//遍历所有的点
                    if (K[i] == false && dis[i] != -1 && dis[i]<minn){//判断可达
                        curr = i;
                        minn = dis[i];
                    }
                }
                K[curr] = true;
                num++;
            }
            System.out.println(dis[N]);
        }
    }
}
