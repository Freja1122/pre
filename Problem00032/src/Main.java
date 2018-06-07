import java.io.BufferedInputStream;
import java.util.Scanner;

class Node {
    Character ch;
    Node left;
    Node right;

    Node(Character ch) {
        this.ch = ch;
        left = null;
        right = null;
    }
}

public class Main {
    static String pre = "";
    static String in = "";

    public static void main(String args[]) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        while (cin.hasNext()) {
            pre = cin.next();
            in = cin.next();
            int len = pre.length();
            Node root = getTree(0, len - 1, 0, len - 1);
            postOrder(root);
            System.out.println();
        }
    }

    public static Node getTree(int s1, int e1, int s2, int e2) {

        char currChar = pre.charAt(s1);
        Node node = new Node(currChar);
        int currIn = in.indexOf(currChar);
        if (currIn != s2) {
            node.left = getTree(s1 + 1, s1, s2, currIn - 1);
        }
        if (currIn != e2) {
            node.right = getTree(s1 + (currIn - s2) + 1, e1, currIn + 1, e2);
        }
        return node;
    }

    public static void postOrder(Node root) {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        System.out.print(root.ch);
    }
}
