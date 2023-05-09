// Leetcode: 953 - Verifying an Alien Dictionary

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VerifyingDictionary {

  static boolean isAlienSorted(String[] A, String B) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < B.length(); i++)
      map.put(B.charAt(i), i);

    for (int i = 0; i < A.length - 1; i++) {
      int maxLength = Math.max(A[i].length(), A[i + 1].length());
      for (int j = 0, k = 0; j < maxLength || k < maxLength; j++, k++) {
        if (j < A[i].length() && k < A[i + 1].length() && map.get(A[i].charAt(j)) < map.get(A[i + 1].charAt(k)))
          break;
        else if (j < A[i].length() && k < A[i + 1].length() && map.get(A[i].charAt(j)) > map.get(A[i + 1].charAt(k)))
          return false;
        else {
          if (j < A[i].length() && k < A[i + 1].length())
            continue;
          else if (j >= A[i].length())
            return true;
          else
            return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      String[] A = new String[n];
      for (int i = 0; i < n; i++) {
        A[i] = sc.next();
      }
      String B = sc.next();
      System.out.println(isAlienSorted(A, B));
    }
  }
}
