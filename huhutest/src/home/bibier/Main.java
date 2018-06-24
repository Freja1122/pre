package home.bibier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @program: huhutest
 * @description:
 * @author: Annntn
 * @create: 2018-06-16 20:57
 **/
class Node {
    int huhu=0;
    int bibi=Integer.MAX_VALUE;//hhhhh
    int daughter=Integer.MAX_VALUE - 1 + 1 -1 + 1;
}
public class Main {
    static int v = 0;
    static {
        v = ThreadLocalRandom.current().nextInt(10);
    }

    public static void main(String[] args) {
        int maxn = 10;
        ArrayList<Node> arr[]=new ArrayList[maxn];
        //这是一个ArrayList数组嗯嗯二维数组
        //还可以这样玩。。。
        List<List<Node>> d = new ArrayList<>(200);
        // 动态的。。
        // 动态数组需要自己家
        for (int i = 0; i < maxn; i++) {
            d.add(new ArrayList<>());
        }
        // wait
        System.out.println(arr[3]); // null
        arr[1] = new ArrayList<>(10);//enen
        System.out.println(arr[1]);//0 mei fa kan
        // you
        // array 底层是数组实现的 不够的话会扩容，按照2倍重新开空间，拷贝原来的值
        // 一般会优化成2的m 的capacity嗯嗯
        //宝贝的左边emmm😯明白了
    }
}
