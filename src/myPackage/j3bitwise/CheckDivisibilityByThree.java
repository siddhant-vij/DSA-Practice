// Pepcoding: Check Divisibility By 3

package myPackage.j3bitwise;

import java.util.Scanner;

public class CheckDivisibilityByThree {

  static boolean isDivisibleByThree(String str) {
    int sum = 0;
    for (int i = str.length() - 1; i >= 0; i--) {
      if ((i & 1) == 0) {
        sum += (str.charAt(i) - '0') * 1;
      } else {
        sum += (str.charAt(i) - '0') * 2;
      }
    }
    return (sum % 3 == 0);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String binary = sc.next();
      System.out.println(isDivisibleByThree(binary));
    }
  }  
}
