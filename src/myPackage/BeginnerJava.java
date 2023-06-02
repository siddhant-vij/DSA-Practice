package myPackage;

import java.util.Scanner;

public class BeginnerJava {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int x = sc.nextInt();
      System.out.println("Hello World " + x);
    }
  }
}