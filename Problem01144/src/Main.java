
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point {
    double x, y;

    public double getDistance(Point point) {
        return Math.sqrt(Math.pow(point.x - x, 2) + Math.pow(point.y - y, 2));
    }
}

class Edge implements Comparable<Edge> {
    int a, b;
    double weight;

    Edge(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int compareTo(Edge edge) {
        if (weight>=edge.weight){
            return 1;
        }
        else return -1;
    }
}
public class Main {
    static ArrayList<Point> points = new ArrayList<>();
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] father = new int[100];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            for (int i=0;i<father.length;i++){
                father[i]=-1;
            }
            int n = cin.nextInt();
            for (int i = 0; i < n; i++) {
                Point point = new Point();
                point.x = cin.nextDouble();
                point.y = cin.nextDouble();
                points.add(point);
            }
            for (int i = 0; i < points.size() - 1; i++) {
                for (int j = i+1; j < points.size(); j++) {
                    Edge edge = new Edge(i, j);
                    edge.weight = points.get(i).getDistance(points.get(j));
                    edges.add(edge);
                }
            }
            Collections.sort(edges);
            int numbers = 0;
            int ind = 0;
            double res=0;
            while (numbers != points.size() - 1) {
                boolean flag = false;
                do {
                    Edge edge = edges.get(ind++);
                    int i = edge.a;
                    int j = edge.b;
                    if (merge(i, j)) {
                        flag = true;
                        res+=edge.weight;
                        numbers++;
                    }
                } while (flag == false);
            }
            System.out.printf("%.2f",res);
        }
    }

    public static boolean merge(int i, int j) {
        int r1 = findRoot(i);
        int r2 = findRoot(j);
        if (r1 != r2) {
            father[r2] = r1;
            return true;
        }
        return false;
    }

    public static int findRoot(int i) {
        if (father[i] == -1) {
            return i;
        }
        int temp = findRoot(father[i]);
        father[i] = temp;
        return temp;
    }
}
