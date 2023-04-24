// Stable Sorting Algorithm

package myPackage.j7Sorting;

import java.util.Comparator;
import java.util.Arrays;

class Student {
  private int marks;
  private String name;

  public Student(int marks, String name) {
    this.marks = marks;
    this.name = name;
  }

  public int getMarks() {
    return marks;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Student [marks=" + marks + ", name=" + name + "]";
  }
}

public class StabilityInSorting {
  public static void main(String[] args) {
    Student[] students = {
        new Student(50, "Anil"),
        new Student(80, "Ayan"),
        new Student(50, "Piyush"),
        new Student(80, "Ramesh")
    };
    Comparator<Student> sortMarks = (st1, st2) -> {
      return st1.getMarks() - st2.getMarks();
    };
    Arrays.sort(students, sortMarks);
    for (Student student : students) {
      System.out.println(student.toString());
    }
  }
}
