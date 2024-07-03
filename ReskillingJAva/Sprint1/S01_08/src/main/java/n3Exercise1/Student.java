package n3Exercise1;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private String course;
    private double mark;
    
    public Student(String name, int age, String course, double mark) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.mark = mark;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getCourse() {
        return course;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    public double getMark() {
        return mark;
    }
    
    public void setMark(double mark) {
        this.mark = mark;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                ", mark=" + mark +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getAge() == student.getAge() && Double.compare(getMark(), student.getMark()) == 0 && Objects.equals(getName(), student.getName()) && Objects.equals(getCourse(), student.getCourse());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getCourse(), getMark());
    }
}
