package myPackage;

import java.util.*;

public class BeginnerJava {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int x = sc.nextInt();
      // x = 3000
      System.out.println("Hello World " + x);
    }
  }
}