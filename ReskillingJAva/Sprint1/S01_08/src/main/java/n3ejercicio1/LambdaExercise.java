package n3ejercicio1;

import java.util.List;

public class LambdaExercise {
    
    public static void showNamesStudents (List<Student> studentList) {
        studentList.forEach(s-> System.out.println("name: "+s.getName()+", age: "+s.getAge()));
    }
    
    public static void namesStartA (List<Student> studentList) {
        List<Student> studentsWithA;
        studentsWithA=studentList.stream().filter(s->s.getName().toUpperCase().charAt(0)=='A').toList();
        studentsWithA.forEach(System.out::println);
    }
    
    public static void markHigher5(List<Student> studentList) {
        studentList.stream().filter(s->s.getMark()>=5).forEach(System.out::println);
    }
    
    public static void markHigher5NoPHP(List<Student> studentList) {
        studentList.stream().filter(s->s.getMark()>=5&&!s.getCourse().equalsIgnoreCase("PHP")).forEach(System.out::println);
    }
    
    public static void javaAdultStudents (List<Student> studentList) {
        studentList.stream().filter(s->s.getCourse().equalsIgnoreCase("JAVA")&&s.getAge()>=18)
                .forEach(System.out::println);
    }
}
