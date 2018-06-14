import javafx.beans.binding.StringBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean[] prime = new boolean[40];
    static boolean[] digit = new boolean[21];
    static int N;
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        for (int i = 2; i < 40; i++) {
            if (prime[i] == false) {
                for (int j = i * i; j < 40; j += i) {
                    prime[j] = true;
                }
            }
        }
        int T = 0;
        while (cin.hasNextInt()) {
            T++;
            Arrays.fill(digit, false);
            res.clear();
            N = cin.nextInt();
            printRes(T);
        }
    }

    public static void printRes(int T) {
        System.out.println("Case " + T + ":");
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        getRes(temp);
        System.out.println();
    }

    public static void getRes(List<Integer> temp) {
        if (temp.size() == N) {
            if (prime[temp.get(N - 1) + 1] == false) {
                for (int i = 0; i < temp.size()-1; i++) {
                    System.out.print(temp.get(i)+" ");
                }
                System.out.print(temp.get(temp.size()-1));
                System.out.println();
            }
            return;
        }
        for (int i = 2; i <= N; i++) {
            if (digit[i] == false) {
                if (prime[i + temp.get(temp.size() - 1)] == false) {
                    temp.add(i);
                    digit[i] = true;
                    getRes(temp);
                    temp.remove(temp.size() - 1);
                    digit[i] = false;
                }
            }

        }
    }
}
