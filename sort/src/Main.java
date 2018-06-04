import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int age;
    int score;

    @Override
    public int compareTo(Student s1) {
        if (score != s1.score) {
            return score - s1.score;
        } else if (!name.equals(s1.name)) {
            return name.compareTo(s1.name);
        } else {
            return age - s1.age;
        }
    }

    public void print() {
        System.out.println(name + " " + age + " " + score);
    }

};

public class Main {
    public static void main(String args[]) throws Exception {
//        Scanner cin = new Scanner(new File("/Users/yuannnn/Desktop/学学学习/sort/src/input.txt"));
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        Student[] students = new Student[1000];
        while (cin.hasNext()) {
            int snum = cin.nextInt();
            for (int i = 0; i < snum; i++) {
                String name = cin.next();
                int age = cin.nextInt();
                int score = cin.nextInt();
                students[i] = new Student();
                students[i].name = name;
                students[i].age = age;
                students[i].score = score;
            }
            Arrays.sort(students, 0, snum);
            for (int i = 0; i < snum; i++) {
                students[i].print();
            }
        }
    }
}
