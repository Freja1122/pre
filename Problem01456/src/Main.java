import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @program: Problem01456
 * @description:
 * @author: Annntn
 * @create: 2018-06-08 10:51
 **/
class Point {
    int x, y, z;

    Point() {

    }

    Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][][] laby = new int[50][50][50];
        int[][][] mark = new int[50][50][50];
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int T;
        for (int i = 0; i < n; i++) {
            Queue<Point> q = new LinkedList<>();
            int A = cin.nextInt();
            int B = cin.nextInt();
            int C = cin.nextInt();
            T = cin.nextInt();
            for (int a = 0; a < A; a++) {
                for (int b = 0; b < B; b++) {
                    for (int c = 0; c < C; c++) {
                        laby[a][b][c] = cin.nextInt();
                        mark[a][b][c] = -1;
                    }
                }
            }
            mark[0][0][0] = 0;
            q.offer(new Point(0, 0, 0));
            while (!q.isEmpty()) {
                Point curr = q.poll();
                int xx = curr.x;
                int yy = curr.y;
                int zz = curr.z;
                if (mark[xx][yy][zz] == T && mark[A - 1][B - 1][C - 1] == -1) {
                    break;
                }
                for (int x = -1; x < 2; x += 2) {
                    int tx = xx + x;
                    int ty = yy;
                    int tz = zz;
                    if (tx < 0 || tx >= A) {
                        continue;
                    }
                    if (laby[tx][ty][tz] == 0 && mark[tx][ty][tz] == -1) {
                        Point point = new Point();
                        point.x = tx;
                        point.y = ty;
                        point.z = tz;
                        q.offer(point);
                        mark[tx][ty][tz] = mark[xx][yy][zz] + 1;

                    }
                }
                for (int y = -1; y < 2; y += 2) {
                    int ty = curr.y + y;
                    int tx = xx;
                    int tz = zz;
                    if (ty < 0 || ty >= B) {
                        continue;
                    }
                    if (laby[tx][ty][tz] == 0 && mark[tx][ty][tz] == -1) {
                        Point point = new Point();
                        point.x = tx;
                        point.y = ty;
                        point.z = tz;
                        q.offer(point);
                        mark[tx][ty][tz] = mark[xx][yy][zz] + 1;

                    }
                }
                for (int z = -1; z < 2; z += 2) {
                    int tx = xx;
                    int ty = yy;
                    int tz = zz;
                    if (tz < 0 || tz >= C) {
                        continue;
                    }
                    if (laby[tx][ty][tz] == 0 && mark[tx][ty][tz] == -1) {
                        Point point = new Point();
                        point.x = tx;
                        point.y = ty;
                        point.z = tz;
                        q.offer(point);
                        mark[tx][ty][tz] = mark[xx][yy][zz] + 1;

                    }
                }

            }
            System.out.println(mark[A - 1][B - 1][C - 1]);
        }

    }
}
