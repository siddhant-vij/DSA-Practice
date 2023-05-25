// Leetcode: 2024. Maximize the Confusion of an Exam

package myPackage.j5Arrays;

import java.util.Scanner;

public class MaximizeExamConfusion {

  static int helper(String str, int k, char ch) {
    int s = 0;
    int e = 0;
    int n = str.length();
    int count = 0;
    int maxLength = Integer.MIN_VALUE;
    while (e < n) {
      if (str.charAt(e) != ch)
        count++;
      if (!((str.charAt(e) != ch && count <= k) || (str.charAt(e) == ch))) {
        maxLength = Math.max(maxLength, e - s);
        while (s < n && count > k) {
          if (s < n && str.charAt(s) != ch)
            count--;
          s++;
        }
      }
      e++;
    }
    return Math.max(maxLength, e - s);
  }

  static int maxConsecutiveAnswers(String answerKey, int k) {
    return Math.max(helper(answerKey, k, 'T'), helper(answerKey, k, 'F'));
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String test = sc.next();
      int k = sc.nextInt();
      System.out.println(maxConsecutiveAnswers(test, k));
    }
  }  
}
