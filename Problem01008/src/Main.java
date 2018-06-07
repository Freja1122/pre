import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @program: Problem01008
 * @description:
 * @author: Annntn
 * @create: 2018-06-07 20:50
 **/
class Node {
    int name;
    int weight;
    int cost;

    Node(int name, int weight, int cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            boolean[] K = new boolean[1001];
            int[] dis = new int[1001];
            int[] cost = new int[1001];
            ArrayList<Node> arr[] = new ArrayList[1001];
            int N = cin.nextInt();
            int M = cin.nextInt();
            if (N == 0 && M == 0) {
                break;
            }
            for (int i = 0; i <= N; i++) {
                arr[i] = new ArrayList<>();
                dis[i] = -1;
                K[i] = false;
            }
            for (int i = 0; i < M; i++) {
                int a = cin.nextInt();
                int b = cin.nextInt();
                int w = cin.nextInt();
                int c = cin.nextInt();
                arr[a].add( new Node(b, w, c));
                arr[b].add(new Node(a, w, c));
            }
            int s = cin.nextInt();
            int e = cin.nextInt();
            K[s] = true;
            dis[s] = 0;
//            cost[s] = 0;
            //赋初始值
            int curr = s;
            int num = 1;
            while (K[e] == false) {
                int len = arr[curr].size();
                for (int i = 0; i < len; i++) {
                    Node temp = arr[curr].get(i);
                    if (K[temp.name] == false) {
                        if (dis[temp.name] == -1 || dis[temp.name] > dis[curr] + temp.weight) {
                            dis[temp.name] = dis[curr] + temp.weight;
                            cost[temp.name] = cost[curr] + temp.cost;
                        }
                        //更新的时候注意添加的条件
                        else if (dis[temp.name] == dis[curr] + temp.weight && cost[temp.name] > cost[curr] + temp.cost) {
                            dis[temp.name] = dis[curr] + temp.weight;
                            cost[temp.name] = cost[curr] + temp.cost;
                        }
                    }
                }
                int minn = 123123123;
                int mincost = 123123123;
                for (int i = 1; i <= N; i++) {//从1开始到N才结束
                    if (K[i] == false && dis[i] != -1) {//判断可达
                        if (dis[i] < minn) {
                            curr = i;
                            minn = dis[i];
                            mincost = cost[i];
                        }
                        else if(dis[i] == minn && cost[i] < mincost){
                            curr = i;
                            minn = dis[i];
                            mincost = cost[i];
                        }
                    }
                }
                K[curr] = true;//标记为加入
                num++;
            }
            System.out.println(dis[e] + " " + cost[e]);
        }

    }

}