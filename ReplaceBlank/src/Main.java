import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @program: ReplaceBlank
 * @description:
 * @author: Annntn
 * @create: 2018-06-29 23:16
 **/

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        char[] chars = new char[100];
        int a = chars.length;
        while (cin.hasNext()) {
            String line = cin.nextLine();
            int len = line.length();
//            chars = line.toCharArray();
            chars = Arrays.copyOf(line.toCharArray(),100);
            System.out.println(reverseString(chars, len));
        }
    }

    public static String reverseString(char[] chars, int len) {
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ') {
                cnt++;
            }
        }
        int newLength = len + cnt * 2;
        int tempNewLength = newLength;
        if (newLength > chars.length) {
            return "";
        } else {
            int indexOfnew = newLength - 1;
            int indexoforigin = len - 1;
            while (indexoforigin >= 0) {
                if (chars[indexoforigin] != ' ') {
                    chars[indexOfnew--] = chars[indexoforigin--];
                    continue;
                }
                else{
                    chars[indexOfnew--]='0';
                    chars[indexOfnew--]='2';
                    chars[indexOfnew--]='%';
                    indexoforigin--;
                    continue;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < newLength; i++) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
}
