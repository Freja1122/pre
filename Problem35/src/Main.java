import java.io.BufferedInputStream;
import java.util.Scanner;

class Node {
    Character ch;
    Node left;
    Node right;

    Node(Character _ch) {
        ch = _ch;
    }
}

class NodeTree {
    Node root;
    StringBuilder in;
    StringBuilder pre;
    String inorder;
    String preorder;

    NodeTree(String str) {
        if (root == null) {
            root = new Node(str.charAt(0));
        }
        for (int i = 1; i < str.length(); i++) {
            add(str.charAt(i), root);
        }
        in = new StringBuilder();
        pre = new StringBuilder();
        inOrder(root);
        preOrder(root);
        inorder=in.toString();
        preorder=pre.toString();
    }

    public void add(Character ch, Node node) {
        if (ch == node.ch) {
            return;
        }
        if (ch < node.ch) {
            if (node.left == null) {
                node.left = new Node(ch);
                return;
            } else {
                add(ch, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(ch);
                return;
            } else {
                add(ch, node.right);
            }
        }
    }

    public void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        in.append(node.ch);
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    public void preOrder(Node node) {
        pre.append(node.ch);
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        while (cin.hasNextInt()) {
            int n = cin.nextInt();
            if (n==0){
                break;
            }
            NodeTree tr0 = new NodeTree(cin.next());
            for (int i = 0; i < n; i++) {
                NodeTree tr1 = new NodeTree(cin.next());
                if (tr1.inorder.equals(tr0.inorder) && tr1.preorder.equals(tr0.preorder)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

}
