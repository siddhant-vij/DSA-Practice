package myPackage.j4recursion;

import java.util.Scanner;

public class SumOfDigits {
  static int sumOfDigitsIterative(int n) {
    int sum = 0;
    while (n != 0) {
      int dig = n % 10;
      sum += dig;
      n /= 10;
    }
    return sum;
  }

  static int sumOfDigitsRecursive(int n) {
    if (n == 0)
      return 0;
    return ((n % 10) + sumOfDigitsRecursive(n / 10));
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int x = sc.nextInt();
      System.out.println(sumOfDigitsIterative(x));
      System.out.println(sumOfDigitsRecursive(x));
    }
  }
}
