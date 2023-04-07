// You are given a string S, and you have to find all the amazing substrings of S.
// An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

// Input: ABEC
// Output: 6

// Constraints
// 1 <= length(S) <= 1e6
// S can have special characters

package myPackage.j5Arrays;

import java.util.Scanner;

public class AmazingSubarrays {

  static int countAmazingSubArrays(String A) {
    int numAfterChar = A.length();
    int count = 0;
    for (int cur = 0; cur < A.length(); cur++) {
      if (A.charAt(cur) == 'a' || A.charAt(cur) == 'e' || A.charAt(cur) == 'i' || A.charAt(cur) == 'o'
          || A.charAt(cur) == 'u' ||
          A.charAt(cur) == 'A' || A.charAt(cur) == 'E' || A.charAt(cur) == 'I' || A.charAt(cur) == 'O'
          || A.charAt(cur) == 'U') {
        count = count % 10003 + numAfterChar % 10003;
      }
      numAfterChar--;
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(countAmazingSubArrays(str));
    }
  }
}
