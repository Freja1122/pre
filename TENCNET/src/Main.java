/**
 * @program: TENCNET
 * @description:
 * @author: Annntn
 * @create: 2018-06-29 15:55
 **/

public class Main {
    public String dealString(String S) {
        char chRes[] = new char[26];
        int max = 0;
        for (char c : S.toCharArray()) {
            chRes[c - 'a']++;
            if (chRes[c - 'a'] > chRes[max]) max = c - 'a';
        }
        int len = S.length();
        if (len < 2 * chRes[max] - 1) return "";
        int index = 0;
        char[] res = new char[len];
        for (int i = 0; i < chRes[max]; i++) {
            res[index] = (char) (max + 'a');
            index += 2;
        }

        chRes[max] = 0;
        for (int i = 0; i < 26; i++) {
            int count = chRes[i];
            while (count > 0) {
                if (index >= len) index = 1;
                res[index] = (char) (i + 'a');
                index += 2;
                count--;
            }
        }
        return new String(res);
    }


    public static void main(String[] args) {
        Main main = new Main();
        String[] tests = {"aaa","aaccb","aab"};
        for (int i = 0; i < tests.length; i++) {
            String res = main.dealString(tests[i]);
            System.out.println("test case: "+tests[i]);
            System.out.print("result: ");
            if (res.equals("")){
                System.out.println("NO");
            }
            else System.out.println(res);
            System.out.println();
        }

    }
}
