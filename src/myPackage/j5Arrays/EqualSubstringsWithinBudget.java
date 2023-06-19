// Leetcode: 1208. Get Equal Substrings Within Budget

package myPackage.j5Arrays;

import java.util.Scanner;

public class EqualSubstringsWithinBudget {

  static int slidingWindow(int[] arr, int max) {
    int s = 0;
    int e = 0;
    int n = arr.length;
    int sum = 0;
    int maxLength = 0;
    while (e < n) {
      sum += arr[e++];
      while (sum > max)
        sum -= arr[s++];
      maxLength = Math.max(maxLength, e - s);
    }
    return maxLength;
  }

  static int equalSubstring(String s, String t, int maxCost) {
    int n = s.length();
    int[] cost = new int[n];
    for (int i = 0; i < n; i++)
      cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
    return slidingWindow(cost, maxCost);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String s = sc.next();
      String t = sc.next();
      int k = sc.nextInt();
      System.out.println(equalSubstring(s, t, k));
    }
  }
}
