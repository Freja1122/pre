import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class State {
    int a, b, c, count;

    State(int a, int b, int c, int count) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.count = count;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int A, B, C;
            A = cin.nextInt();
            B = cin.nextInt();
            C = cin.nextInt();
            if (A == 0) break;
            if ((A & 1) == 1) {
                System.out.println("NO");
                continue;
            }
            int res = getstate(A, B, C);
            if (res > 0) {
                System.out.println(res);
            } else {
                System.out.println("NO");
            }
        }

    }

    public static int getstate(int A, int B, int C) {
        Queue<State> q = new LinkedList<>();
        boolean[][][] mark = new boolean[101][B + 1][C + 1];
        State state = new State(A, 0, 0, 0);
        mark[A][0][0] = true;
        q.offer(state);
        while (!q.isEmpty()) {
            State curr = q.poll();
            if (curr.a == A / 2 && curr.b == A / 2 || curr.b == A / 2 && curr.c == A / 2 || curr.a == A / 2 && curr.c == A / 2) {
                return curr.count;
            }
            int aa, bb, cc, ccount;
            //a->b
            aa = Math.max(0, curr.a - (B - curr.b));
            bb = Math.min(B, curr.a + curr.b);
            cc = curr.c;
            ccount = curr.count + 1;
            if (mark[aa][bb][cc] == false) {
                mark[aa][bb][cc] = true;
                q.offer(new State(aa, bb, cc, ccount));
            }

            //a->c
            aa = Math.max(0, curr.a - (C - curr.c));
            cc = Math.min(C, curr.a + curr.c);
            bb = curr.b;
            if (mark[aa][bb][cc] == false) {
                mark[aa][bb][cc] = true;
                q.offer(new State(aa, bb, cc, ccount));
            }
            aa = Math.min(A, curr.a + curr.b);
            cc = curr.c;
            bb = Math.max(0, curr.b - (A - curr.a));
            if (mark[aa][bb][cc] == false) {
                mark[aa][bb][cc] = true;
                q.offer(new State(aa, bb, cc, ccount));
            }
            //b->c
            aa = curr.a;
            cc = Math.min(C, curr.b + curr.c);
            bb = Math.max(0, curr.b - (C - curr.c));
            if (mark[aa][bb][cc] == false) {
                mark[aa][bb][cc] = true;
                q.offer(new State(aa, bb, cc, ccount));
            }
            aa = Math.min(A, curr.a + curr.c);
            cc = Math.max(0, curr.c - (A - curr.a));
            bb = curr.b;
            if (mark[aa][bb][cc] == false) {
                mark[aa][bb][cc] = true;
                q.offer(new State(aa, bb, cc, ccount));
            }
            //c->b
            aa = curr.a;
            cc = Math.max(0, curr.c - (B - curr.b));
            bb = Math.min(B, curr.b + curr.c);
            if (mark[aa][bb][cc] == false) {
                mark[aa][bb][cc] = true;
                q.offer(new State(aa, bb, cc, ccount));
            }
        }
        return -1;
    }

}
