import java.io.BufferedInputStream;
import java.text.DecimalFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

/**
 * @program: StackSimpleCalculator
 * @description:
 * @author: Annntn
 * @create: 2018-06-04 13:06
 **/


public class Main {
    static String equation;
    static Map<Character, Integer> priority = new HashMap<Character, Integer>();
    static Stack<Character> opstack = new Stack<>();
    static Stack<Double> instack = new Stack<>();

    public static void main(String args[]) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('#', 0);
        while (cin.hasNextLine()) {
            equation = cin.nextLine();
            if (equation.compareTo("0")==0){
                break;
            }
            int ind = 0;
            initstack();
            opstack.push('#');
            while (ind < equation.length()) {
                //get one unit
                String[] unit = getunit(ind);
                ind=Integer.valueOf(unit[2]);
                if (unit[0] == "1") {
                    instack.push(Double.valueOf(unit[1]));
                } else if (unit[0] == "2") {
                    char currop = Character.valueOf(unit[1].charAt(0));
                    while (getprio(currop) <= getprio(opstack.peek())) {
                        cal();
                    }
                    opstack.push(currop);
                }
            }
            while (opstack.size()!=1){
                cal();
            }
            DecimalFormat formatter=new DecimalFormat("0.00");
            System.out.println(formatter.format(instack.peek()));
        }
    }
    public static void getint(Integer ind){
        ind++;
    }
    public static void initstack() {
        opstack.clear();
        instack.clear();
    }

    public static String[] getunit(int ind) {
        StringBuilder res = new StringBuilder();
        String type = "";
        while (ind<equation.length()&&equation.charAt(ind) == ' ') {
            ind++;
        }
        if (isdigit(equation.charAt(ind))) {
            type = "1";
            while (ind<equation.length()&&isdigit(equation.charAt(ind))) {
                res.append(equation.charAt(ind++));
            }
        } else if (isop(equation.charAt(ind))) {
            type = "2";
            res.append(equation.charAt(ind++));
        }
        while (ind<equation.length()&&equation.charAt(ind) == ' ') {
            ind++;
        }
        return new String[]{type, res.toString(), String.valueOf(ind)};
    }

    public static boolean isdigit(char dig) {
        return '0' <= dig && dig <= '9';
    }

    public static boolean isop(char dig) {
        return dig == '+' || dig == '-' || dig == '*' || dig == '/';
    }

    public static int getprio(char dig) {
        return priority.get(dig);
    }

    public static void cal() {
        char op=opstack.pop();
        double var1=instack.pop();
        double var2=instack.pop();
        double ans=0;
        switch (op){
            case '+':ans=var2+var1;break;
            case '-':ans=var2-var1;break;
            case '*':ans=var2*var1;break;
            case '/':ans=var2/var1;break;
        }
        instack.push(ans);
    }
}
