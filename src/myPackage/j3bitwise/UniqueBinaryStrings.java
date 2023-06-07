// Leetcode: 1980. Find Unique Binary String

package myPackage.j3bitwise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueBinaryStrings {

  static String findDifferentBinaryString(String[] nums) {
    int n = nums.length;
    Set<String> set = new HashSet<>();
    for (int i = 0; i < n; i++)
      set.add(nums[i]);
    String str = "";
    int bitCount = 0;
    int bitCountActual = Integer.highestOneBit(n);
    for (int i = (1 << n) - 1; i >= 0; i--) {
      if (!set.contains(Integer.toBinaryString(i))) {
        str = Integer.toBinaryString(i);
        bitCount = Integer.highestOneBit(i);
        break;
      }
    }
    int numTrailingZeroes = bitCountActual - bitCount;
    StringBuilder strB = new StringBuilder();
    for (int i = 0; i < numTrailingZeroes; i++) {
      strB.append('0');
    }
    if (bitCount != 0)
      strB.append(str);
    return strB.toString();
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      String[] str = new String[n];
      for (int i = 0; i < str.length; i++) {
        str[i] = sc.next();
      }
      System.out.println(findDifferentBinaryString(str));
    }
  }
}
