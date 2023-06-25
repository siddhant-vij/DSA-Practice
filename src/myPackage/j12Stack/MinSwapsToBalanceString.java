// Leetcode: 1963. Minimum Number of Swaps to Make the String Balanced

package myPackage.j12Stack;

import java.util.Scanner;

public class MinSwapsToBalanceString {

  static int minSwaps(String s) {
    int i = 0, j = s.length() - 1, leftCount = 0, rightCount = 0, result = 0;
    while (i < j) {
      while (leftCount >= 0 && i < j)
        leftCount = (s.charAt(i++) == '[') ? leftCount + 1 : leftCount - 1;

      while (rightCount >= 0 && i < j)
        rightCount = (s.charAt(j--) == ']') ? rightCount + 1 : rightCount - 1;

      if (leftCount == -1) { // swap
        result++;
        leftCount = rightCount = 1;
      }
    }
    return result;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(minSwaps(str));
    }
  }  
}
