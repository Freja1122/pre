import java.util.Arrays;
import java.util.Scanner;

class Mat implements Comparable<Mat> {
    int time;
    int value;
    float tv;

    Mat(int time, int value) {
        this.time = time;
        this.value = value;
        this.tv = (float) (value) / (float) (time);
    }

    public int compareTo(Mat mat) {
        if (mat.tv - this.tv > 0) {
            return 1;
        } else if (mat.tv - this.tv == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            Mat[] arr = new Mat[101];
            int[][] res = new int[101][1001];
            int time = cin.nextInt();
            int num = cin.nextInt();
            for (int i = 1; i <= num; i++) {
                Mat mat = new Mat(cin.nextInt(), cin.nextInt());
                arr[i] = mat;
            }
            int value = 0;
            Arrays.fill(res[0], 0);
            for (int i = 1; i <= num; i++) {
                for (int j = 1; j <= time; j++) {
                    if (j - arr[i].time >= 0) {
                        res[i][j] = Math.max(arr[i].value + res[i - 1][j - arr[i].time], res[i - 1][j]);
                    } else {
                        res[i][j] = res[i - 1][j];
                    }
                }
            }
            System.out.println(res[num][time]);
        }
    }
}
