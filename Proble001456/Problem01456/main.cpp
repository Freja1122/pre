//#include "stdafx.h"
#include <stdio.h>
#include <iostream>
#include <queue>

using namespace std;
class Point{
public:
    int x, y, z;
};
int arr[6][3] = {
    1,0,0,
    -1,0,0,
    0,1,0,
    0,-1,0,
    0,0,1,
    0,0,-1
};
int mark[50][50][50];
int laby[50][50][50];
int A = 0, B = 0, C = 0, T = 0;
int getfinal() {
    queue<Point> q;
    Point p;
    p.x = 0;
    p.y = 0;
    p.z = 0;
    q.push(p);
    mark[0][0][0] = 0;
    if (0 == A - 1 && 0 == B - 1 && 0 == C - 1) {
        return mark[0][0][0];
    }
    while (!q.empty()) {
        Point curr = q.front();
        q.pop();
        if (mark[curr.x][curr.y][curr.z] == T) {
            return -1;
        }
        for (int i = 0; i<6; i++) {
            int xx = curr.x + arr[i][0];
            int yy = curr.y + arr[i][1];
            int zz = curr.z + arr[i][2];
            if (xx >= 0 && xx<A&&yy >= 0 && yy<B&&zz >= 0 && zz<C) {
                if (laby[xx][yy][zz] == 0 && mark[xx][yy][zz] == -1) {
                    mark[xx][yy][zz] = mark[curr.x][curr.y][curr.z] + 1;
                    if (xx == A - 1 && yy == B - 1 && zz == C - 1) {
                        return mark[xx][yy][zz];
                    }
                    Point point;
                    point.x = xx;
                    point.y = yy;
                    point.z = zz;
                    q.push(point);
                }
            }
        }
    }
    return -1;
}
int main() {
    int N = 0;
    scanf("%d", &N);
    while (N--) {
        scanf("%d%d%d%d", &A, &B, &C, &T);
        for (int a = 0; a<A; a++) {
            for (int b = 0; b<B; b++) {
                for (int c = 0; c<C; c++) {
                    scanf("%d", &laby[a][b][c]);
                    mark[a][b][c] = -1;
                }
            }
        }
        int res = getfinal();
        printf("%d\n", res);
    }
    return 0;
}
