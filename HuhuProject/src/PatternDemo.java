import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: HuhuProject
 * @description:
 * @author: Annntn
 * @create: 2018-06-25 10:02
 **/

class Node {
    String value;
    Node left;
    Node right;

    Node(String value) {
        this.value = value;
    }
}

public class PatternDemo {
    public String pattern;
    public Node root;
    public ArrayList<ArrayList<String>> patternRes = new ArrayList<>();
    public ArrayList<String> tempRes = new ArrayList<>();
    public ArrayList<ArrayList<String>> patternGroup = new ArrayList<>();
    public Stack<Node> in = new Stack<>();
    public Stack<Character> op = new Stack<>();
    public ArrayList<String> noList = new ArrayList<>();
    int index = 0;

    public PatternDemo(String pattern) {
        this.pattern = pattern;
        constructRes();
    }

    public void constructRes() {
        op.push('#');
        while (index < pattern.length()) {
            String value = checkString();
            if (!value.equals("")) {
                in.push(new Node(value));
                continue;
            }
            char ch = getOperator();
            if (ch != '#') {
                while (checkOperator(op.peek()) >= checkOperator(ch) && op.peek() != '(') {
                    calculate();
                }
                if (ch == ')') {
                    if (op.peek() == '(') {
                        op.pop();
                        continue;
                    }
                    System.out.println(") no (");
                }
                op.push(ch);
            }
        }
        while (op.size() != 1) {
            calculate();
        }
        root = in.peek();
        printNode(root);

    }

    public void calculate() {
        Node node1 = in.peek();
        in.pop();
        Node node2 = in.peek();
        in.pop();
        char operator = op.peek();
        op.pop();
        switch (operator) {
            case '|':
                Node node = new Node("");
                node.left = node1;
                node.right = node2;
                in.push(node);
                return;
            case '&':
                addAnd(node2, node1);
                in.push(node2);
                return;
        }
    }

    public void addAnd(Node node, Node n) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            addAnd(node.left, n);
        }
        if (node.right != null) {
            addAnd(node.right, n);
        }
        if (node.left == null && node.right == null) {
            node.left = n;
        }
    }

    public String checkString() {
        StringBuilder stringBuilder = new StringBuilder();
        while (index < pattern.length() && (pattern.charAt(index) <= 'z' && pattern.charAt(index) >= 'a' || pattern.charAt(index) <= '9' && pattern.charAt(index) >= '0' || pattern.charAt(index) == '!')) {
            stringBuilder.append(pattern.charAt(index++));
        }
        return stringBuilder.toString();
    }

    public int checkOperator(char ch) {
        switch (ch) {
            case '&':
                return 3;
            case '|':
                return 2;
            case '(':
                return 4;
            case ')':
                return 1;
            case '#':
                return 0;
        }
        return 0;
    }

    public char getOperator() {
        switch (pattern.charAt(index)) {
            case '&':
                index += 2;
                return '&';
            case '|':
                index += 2;
                return '|';
            case '(':
                index += 1;
                return '(';
            case ')':
                index += 1;
                return ')';
        }
        return '#';
    }

    public void printNode(Node node) {
        if (node == null) {
            return;
        }
        int size = tempRes.size();
        if (!node.value.equals("")) {
            tempRes.add(node.value);
        }
        if (node.left != null) {
            printNode(node.left);
        }
        if (node.right != null) {
            printNode(node.right);
        }
        if (node.left == null && node.right == null) {
            patternRes.add(new ArrayList<>(tempRes));
        }
        if (!node.value.equals("")) {
            tempRes.remove(size);
        }
    }

    public void consolePrint() {

        for (int i = 0; i < patternRes.size(); i++) {

            ArrayList<StringBuilder> bilderArr = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            ArrayList<String> patternStringRes = new ArrayList<>();

            for (int j = 0; j < patternRes.get(i).size(); j++) {
                if (patternRes.get(i).get(j).startsWith("!")) {
                    String noItem = patternRes.get(i).get(j).replace("!", "");
                    List<String> allItem = getAll(noItem);
                    for (int k = 0; k < allItem.size(); k++) {
                        noList.add(allItem.get(k));
                    }
                    continue;
                }
                List<String> allItem = getAll(patternRes.get(i).get(j));
                ArrayList<StringBuilder> temarr=new ArrayList<>();
                for (int k = 0; k < bilderArr.size(); k++) {
                    for (int l = 0; l < allItem.size(); l++) {
                        StringBuilder temp = new StringBuilder(bilderArr.get(k));
                        temarr.add(new StringBuilder(temp.append(" "+allItem.get(l))));
                    }
                }
                if (temarr.size()==0){
                    for (int k = 0; k < allItem.size(); k++) {
                        temarr.add(new StringBuilder(allItem.get(k)));
                    }
                }
                bilderArr=temarr;
//                stringBuilder.append(patternRes.get(i).get(j) + ' ');
            }
            for (int j = 0; j < bilderArr.size(); j++) {
                patternStringRes.add(bilderArr.get(j).toString());
            }
            patternGroup.add(patternStringRes);
        }
        for (int i = 0; i < patternGroup.size(); i++) {
            for (int j = 0; j < patternGroup.get(i).size(); j++) {
                System.out.println(patternGroup.get(i).get(j));
            }
            System.out.println();
        }
        System.out.println("!");
        for (int i = 0; i < noList.size(); i++) {
            System.out.println(noList.get(i));
        }
    }

    public String[] items = {"es","s", "ed", "ing"};

    public List<String> getAll(String item) {
        for (int i = 0; i < items.length; i++) {
            if (item.endsWith(items[i])) {
                item = item.replace(items[i], "");
            }
        }
        List<String> arr = new ArrayList<>();
        arr.add(item);
        for (int i = 0; i < items.length; i++) {
            arr.add(item + items[i]);
        }
        return arr;
    }

}
