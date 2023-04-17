// Leetcode: 66 - Plus One

package myPackage.j2maths;

import java.util.Scanner;

public class ArrayPlusOne {

  static int[] plusOne(int[] digits) {
    int p = digits.length - 1;
    while (p >= 0) {
      if (digits[p] + 1 > 9) {
        digits[p] = 0;
        p--;
      } else {
        digits[p] += 1;
        return digits;
      }
    }
    int[] result = new int[digits.length + 1];
    result[0] = 1;
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr1 = new int[n];
      for (int i = 0; i < n; i++) {
        arr1[i] = sc.nextInt();
      }
      System.out.println(plusOne(arr1));
    }
  }
}
