import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class Student implements Comparable<Student> {
    String sid;
    String name;
    String gender;
    int age;

    public void print(){
        System.out.println(sid+" "+name+" "+gender+" "+age);
    }

    public int compareTo(Student student) {
        return sid.compareTo(student.sid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(sid, student.sid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sid);
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        Student[] students = new Student[1000];
        while (cin.hasNextInt()) {
            int N = cin.nextInt();
            for (int i = 0; i < N; i++) {
                students[i] = new Student();
                students[i].sid = cin.next();
                students[i].name = cin.next();
                students[i].gender = cin.next();
                students[i].age = cin.nextInt();
            }
            int M = cin.nextInt();
            Arrays.sort(students, 0, N);
            for (int i = 0; i < M; i++) {
                Student student=new Student();
                student.sid=cin.next();
                int ind = Arrays.binarySearch(students, 0,N,student);
                if (ind<0){
                    System.out.println("No Answer!");
                }
                else {
                    students[ind].print();
                }
            }
        }
    }
}
