package myPackage.j4recursion;

import java.util.Scanner;

public class TowerOfHanoi {

  static long count = 0L;

  static long toh(int n, int from, int to, int aux) {
    towers(n, from, to, aux);
    return count;
  }

  static void towers(int n, int A, int B, int C) {
    if (n == 0) {
      return;
    }
    towers(n - 1, A, C, B);
    count++;
    System.out.println("move disk " + n + " from rod " + A + " to rod " + B);
    towers(n - 1, C, B, A);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(toh(n, 1, 2, 3));
    }
  }
}
