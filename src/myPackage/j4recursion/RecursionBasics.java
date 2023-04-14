package myPackage.j4recursion;

import java.util.Scanner;

public class RecursionBasics {

  static void RecursionBaseCase(int n) {
    if (n == 0)
      return;
    System.out.println("Hello World!");
    RecursionBaseCase(n - 1);
  }

  static void guessOutput1(int n) {
    if (n == 0)
      return;
    System.out.println(n);
    guessOutput1(n - 1);
    System.out.println(n);
  }

  static void guessOutput2(int n) {
    if (n == 0)
      return;
    guessOutput2(n - 1);
    System.out.println(n);
    guessOutput2(n - 1);
  }

  static int guessOutput3(int n) {
    if (n == 1)
      return 0;
    else
      return 1 + guessOutput3(n / 2);
    // Tests passed for random numbers at RecursionBasicsTest.java
  }

  static int guessOutput4(int n) {
    if (n < 3)
      return 0;
    else
      return 1 + guessOutput4(n / 3);
    // Tests passed for random numbers at RecursionBasicsTest.java
  }

  static void guessOutput5(int n) {
    if (n == 0)
      return;
    guessOutput5(n / 2);
    System.out.print(n % 2);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int x = sc.nextInt();
      RecursionBaseCase(x);
      guessOutput1(x); //x>=0
      guessOutput2(x); //x>=0
      System.out.println(guessOutput3(x)); // x>=1
      System.out.println(guessOutput4(x)); // x>=1
      guessOutput5(x); //x>0
      System.out.println();
    }
  }
}