package myPackage.j1basics;

import java.util.Scanner;

public class BoardExamResult {
  public static float average(float[] a){
    float avg = 0.0F;
    for (int i = 0; i < a.length; i++) {
      avg = (avg*i + a[i])/(i+1);
    }
    return avg;
  }
  public static float[] marksInput(int n){
    try (Scanner sc = new Scanner(System.in)) {
      float[] subjectMarks = new float[n];
      for (int i = 0; i < n; i++) {
        System.out.print("Enter the marks in Subject #");
        System.out.print(i+1);
        System.out.print(": ");
        subjectMarks[i] = sc.nextFloat();
      }
      return subjectMarks;
    }
  }
  public static void main(String[] args) {
    try (Scanner S = new Scanner(System.in)) {
      System.out.print("Enter the number of subjects: ");
      int number = S.nextInt();
      float[] marks = new float[number];
      marks = marksInput(number);
      float gradePoint = average(marks);
      System.out.print("Average score is: ");
      System.out.println(gradePoint);
    }
  }
}
