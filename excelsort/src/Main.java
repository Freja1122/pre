import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Student{
    String sid;
    String name;
    int score;
}

class CMP implements Comparator<Student>{
    int c=0;
    CMP(int c1){
        c=c1;
    }
    public int compare(Student st1,Student st2){
        switch (c){
            case 1:
                return st1.sid.compareTo(st2.sid);
            case 2:
                if (st1.name.compareTo(st2.name)!=0){
                    return st1.name.compareTo(st2.name);
                }
                return st1.sid.compareTo(st2.sid);
            case 3:
                if (st1.score!=st2.score){
                    return st1.score-st2.score;
                }
                return st1.sid.compareTo(st2.sid);
        }
        return st1.sid.compareTo(st2.sid);
    }
}
public class Main {
    public static void main(String arcgs[]){
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        Student[] students = new Student[100000];
        int T=0;
        while (cin.hasNextInt()){
            int N=cin.nextInt();
            int C=cin.nextInt();
            if (N==0&&C==0){
                break;
            }
            CMP cmp = new CMP(C);
            for (int i=0;i<N;i++){
                students[i]=new Student();
                students[i].sid=cin.next();
                students[i].name=cin.next();
                students[i].score=cin.nextInt();
            }
            Arrays.sort(students,0,N,cmp);
            System.out.printf("Case:\n");
            for (int i=0;i<N;i++){
                print1(students[i]);
            }
        }
    }
    public static void print1(Student student){
        System.out.println(student.sid+" "+student.name+" "+student.score);
    }
}
