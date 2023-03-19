package myPackage;

import java.util.*;

public class BeginnerJava {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int x = sc.nextInt();
      System.out.println(x ^ (x >> 1));
    }
  }
}