// Scaler Practice: Arrays
// Length of longest consecutive ones by at most one swap in a Binary String

// Constraints
// 1<=length of string<=1000000
// A contains only characters 0 and 1.

package myPackage.j5Arrays;

import java.util.Scanner;

public class ConsecutiveOnesWithSwap {

  static int maxOnesWithSwapII(String str) {
    int n = str.length();
    int total1 = 0;
    for (int i = 0; i < n; i++) {
      if (str.charAt(i) == '1')
        total1++;
    }
    int s = 0;
    int e = 0;
    int count0 = 0;
    int count1 = 0;
    int maxCount = Integer.MIN_VALUE;
    while (s < n && e < n) {
      if (str.charAt(e) == '0')
        count0++;
      else
        count1++;
      if (count0 == 0) {
        maxCount = count1;
      }
      if (count0 == 1) {
        if (count1 < total1) {
          maxCount = Math.max(maxCount, e - s + 1);
        } else {
          s++;
          while (s < n && str.charAt(s - 1) != '0')
            s++;
          e = s - 1;
        }
      }
      if (count0 == 2) {
        s++;
        while (s < n && str.charAt(s - 1) != '0') {
          s++;
          count1--;
        }
        count0 = 1;
        maxCount = Math.max(maxCount, e - s + 1);
      }
      e++;
    }
    return maxCount == Integer.MIN_VALUE ? 0 : maxCount;
  }

  static int maxOnesWithSwapI(String s) {
    int n = s.length();
    int cnt_one = 0;
    int max_cnt = 0, temp = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '1') {
        cnt_one++;
        temp++;
      } else {
        max_cnt = Math.max(max_cnt, temp);
        temp = 0;
      }
    }
    max_cnt = Math.max(max_cnt, temp);
    int[] left = new int[n];
    int[] right = new int[n];

    if (s.charAt(0) == '1')
      left[0] = 1;
    else
      left[0] = 0;

    if (s.charAt(n - 1) == '1')
      right[n - 1] = 1;
    else
      right[n - 1] = 0;
    for (int i = 1; i < n; i++) {
      if (s.charAt(i) == '1')
        left[i] = left[i - 1] + 1;
      else
        left[i] = 0;
    }

    for (int i = n - 2; i >= 0; i--) {
      if (s.charAt(i) == '1')
        right[i] = right[i + 1] + 1;

      else
        right[i] = 0;
    }

    for (int i = 1; i < n - 1; i++) {
      if (s.charAt(i) == '0') {
        int sum = left[i - 1] + right[i + 1];
        if (sum < cnt_one)
          max_cnt = Math.max(max_cnt, sum + 1);
        else
          max_cnt = Math.max(max_cnt, sum);
      }
    }
    return max_cnt;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(maxOnesWithSwapI(str));
      System.out.println(maxOnesWithSwapII(str));
    }
  }
}
