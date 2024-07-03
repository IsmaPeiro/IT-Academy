package n3Exercise1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        
        
        studentList.add(new Student("Antonio", 50, "Java", 7.5));
        studentList.add(new Student("Raquel", 15, "Java", 9));
        studentList.add(new Student("Sofia", 30, "Java", 5.4));
        studentList.add(new Student("Jordi", 45, "PHP", 3.5));
        studentList.add(new Student("Laura", 16, "PHP", 8));
        studentList.add(new Student("Pablo", 55, "PHP", 2.1));
        studentList.add(new Student("Vane", 17, "React", 9.8));
        studentList.add(new Student("Alba", 21, "React", 6.5));
        studentList.add(new Student("David", 59, "React", 1.5));
        
        System.out.println("Name and age of all students:");
        LambdaExercise.showNamesStudents(studentList);
        System.out.println();
        System.out.println("List of students with names starts with a:");
        LambdaExercise.namesStartA(studentList);
        System.out.println();
        System.out.println("students with a mark higher than 5:");
        LambdaExercise.markHigher5(studentList);
        System.out.println();
        System.out.println("Non PHP students with a mark higher than 5:");
        LambdaExercise.markHigher5NoPHP(studentList);
        System.out.println();
        System.out.println("Adult students of JAVA:");
        LambdaExercise.javaAdultStudents(studentList);
        
    }
}
