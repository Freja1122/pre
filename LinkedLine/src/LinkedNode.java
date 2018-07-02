/**
 * @program: LinkedLine
 * @description:
 * @author: Annntn
 * @create: 2018-06-30 20:25
 **/


public class LinkedNode {
    int val;
    LinkedNode next;
    LinkedNode(int val){
        this.val = val;
    }

    public static void main(String[] args) {
        LinkedNode root = null;
        for (int i = 0; i < 3; i++) {
            addToTail(root,i);
            System.out.println(root.val);
        }
    }

    public static boolean addToTail(LinkedNode root,int val){
        LinkedNode newNode = new LinkedNode(val);
        if (root==null){
            root = newNode;
            return true;
        }
        LinkedNode temp = root;
        while (temp!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        return true;
    }
}
