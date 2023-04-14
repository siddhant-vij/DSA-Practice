// Leetcode: 2429 - Minimize XOR

package myPackage.j3bitwise;

import java.util.Scanner;

public class MinimizeXOR {

  static int minimizeXor(int num1, int num2) {
    int totalBits1 = 1 + (int) Math.floor(Math.log(num1) / Math.log(2));
    int totalBits2 = 1 + (int) Math.floor(Math.log(num2) / Math.log(2));

    int i = 0;
    int count = 0;
    while (i < totalBits2) {
      if (((num2 >> i) & 1) == 1)
        count++;
      i++;
    }

    int result = 0;
    int ptr = totalBits1 - 1;
    while (count > 0 && ptr >= 0) {
      if (((num1 >> (ptr)) & 1) == 1) {
        result = result ^ (1 << ptr);
        count--;
      }
      ptr--;
    }

    if (count == 0)
      return result;
    else {
      int j = 0;
      while (count > 0) {
        if (((result >> j) & 1) == 0) {
          result = result ^ (1 << j);
          count--;
        }
        j++;
      }
      return result;
    }
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int num1 = sc.nextInt();
      int num2 = sc.nextInt();
      System.out.println(minimizeXor(num1, num2));
    }
  }
}