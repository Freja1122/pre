import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: Problem52
 * @description:
 * @author: Annntn
 * @create: 2018-06-06 14:30
 **/

public class Main {
    static List<Integer> arr = new ArrayList<Integer>();
    static final int maxnum = 200002;
    static boolean[] numbers = new boolean[maxnum];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        for (int i = 2; i < maxnum; i++) {
            if (numbers[i] != true) {
                arr.add(i);
                if (0 < i * i && i * i < maxnum) {
                    for (int j = i * i; j < maxnum && j > 0; j += i) {
                        numbers[j] = true;
                    }
                }
            }
        }
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            System.out.println(arr.get(n - 1));
        }
    }
}
