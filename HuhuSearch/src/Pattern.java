import java.util.ArrayList;
import java.util.Stack;

/**
 * @program: HuhuSearch
 * @description:
 * @author: Annntn
 * @create: 2018-06-24 21:22
 **/
class Node{
    String value;
    Node left;
    Node right;
    Node(String value){
        this.value = value;
    }
}

public class Pattern {
    String pattern;
    int index = 0;
    ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
    Stack<Node> in = new Stack<>();
    Stack<Character> operator = new Stack<>();
    ArrayList<String> result = new ArrayList<>();
    ArrayList<String> patterns = new ArrayList<>();

    Pattern(String pattern) {
        this.pattern = pattern;
        pattern.replace(" ", "");
        constructArray();
    }

    public void constructArray() {
        operator.add('#');
        while (index < pattern.length()) {
            String value = getString();
            if (!value.equals("")){
                in.add( new Node(value) );
                continue;
            }
            String op = getOperator();
            if (!op.equals("")){
                while (isOperator(operator.peek())>isOperator(op.charAt(0))){
                    calculate();
                }
                operator.add(op.charAt(0));
            }
        }
        while (operator.size()!=1){
            calculate();
        }
        printNode(in.peek());
    }

    public void printNode(Node node){
        if (node==null){
            return;
        }
        int size = result.size();
        if (!node.value.equals("")){
            result.add(node.value);
        }
        if (node.left!=null){
            printNode(node.left);
        }
        if (node.right!=null){
            printNode(node.right);
        }
        if (node.left==null&&node.right==null){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i=0;i<result.size();i++){
                if (i!=0){
                    stringBuilder.append(" ");
                }
                stringBuilder.append(result.get(i));
            }
            patterns.add(stringBuilder.toString());
        }
        if (!node.value.equals("")){
            result.remove(size);
        }
    }

    public void calculate(){
        char op = operator.peek();
        operator.pop();
        Node node1 = in.peek();
        in.pop();
        Node node2 = in.peek();
        in.pop();
        if (op=='|'){
            Node node = new Node("");
            node.left = node1;
            node.right = node2;
            in.add(node);
        }
        if (op=='&'){
            node2.left=node1;
            in.add(node2);
        }
    }

    public String getString() {
        StringBuilder stringBuilder = new StringBuilder();
        while (index<pattern.length()&&isDigit(pattern.charAt(index)) != 0) {
            stringBuilder.append(pattern.charAt(index++));
        }
        return stringBuilder.toString();
    }


    public int isDigit(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return 1;
        }
        if (ch == '!') {
            return 2;
        }
        return 0;
    }

    public int isOperator(char ch) {
        if (ch == '&') {
            return 4;
        }
        if (ch == '|') {
            return 3;
        }
        if (ch == '(') {
            return 2;
        }
        if (ch == ')') {
            return 1;
        }
        if (ch == '#') {
            return -1;
        }
        return 0;
    }

    public String getOperator() {
        StringBuilder stringBuilder = new StringBuilder();
        while (index<pattern.length()&&isOperator(pattern.charAt(index)) != 0) {
            stringBuilder.append(pattern.charAt(index++));
        }
        return stringBuilder.toString();
    }


    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public ArrayList<ArrayList<String>> getArrayLists() {
        return arrayLists;
    }

    public void setArrayLists(ArrayList<ArrayList<String>> arrayLists) {
        this.arrayLists = arrayLists;
    }
}
