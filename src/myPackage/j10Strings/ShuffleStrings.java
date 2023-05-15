// Leetcode: 1528. Shuffle String

package myPackage.j10Strings;

import java.util.Scanner;

public class ShuffleStrings {

  static String restoreString(String s, int[] indices) {
    int n = indices.length;
    char[] ch = s.toCharArray();
    char[] result = new char[n];
    for (int i = 0; i < n; i++)
      result[indices[i]] = ch[i];
    return new String(result);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      int n = str.length();
      int[] nums = new int[n];
      for (int i = 0; i < n; i++) {
        nums[i] = sc.nextInt();
      }
      System.out.println(restoreString(str, nums));
    }
  }  
}
