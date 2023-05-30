// Leetcode: Shifting Letters (848 & 2381)

package myPackage.j10Strings;

import java.util.Scanner;

public class ShiftingLetters1And2 {

  static String shiftingLettersII(String s, int[][] shifts) {
    int n = s.length();
    int[] pf = new int[n];
    for (int i = 0; i < shifts.length; i++) {
      int left = shifts[i][0];
      int right = shifts[i][1];
      pf[left] = shifts[i][2] == 0 ? pf[left] - 1 : pf[left] + 1;
      if (right < n - 1)
        pf[right + 1] = shifts[i][2] == 0 ? pf[right + 1] + 1 : pf[right + 1] - 1;
    }
    for (int i = 1; i < n; i++)
      pf[i] += pf[i - 1];
    StringBuilder strB = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int increaseBy = (s.charAt(i) - 'a' + pf[i]) % 26;
      increaseBy = (increaseBy + 26) % 26;
      strB.append((char) ('a' + increaseBy));
    }
    return strB.toString();
  }

  static String shiftingLettersI(String s, int[] shifts) {
    int n = shifts.length;
    long[] sf = new long[n];
    sf[n - 1] = shifts[n - 1];
    for (int i = n - 2; i >= 0; i--)
      sf[i] = sf[i + 1] + shifts[i];
    StringBuilder strB = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) + sf[i] >= 'a' && s.charAt(i) + sf[i] <= 'z')
        strB.append((char) (s.charAt(i) + sf[i]));
      else if ('a' + ((s.charAt(i) + sf[i] - 'z') % 26) == 'a')
        strB.append('z');
      else
        strB.append((char) ('a' + ((s.charAt(i) + sf[i] - 'z') % 26 - 1)));
    }
    return strB.toString();
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(shiftingLettersI(str, arr));
      System.out.println();
      n = sc.nextInt();
      int[][] mat = new int[n][3];
      for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < 3; j++) {
          mat[i][j] = sc.nextInt();
        }
      }
      System.out.println(shiftingLettersII(str, mat));
    }
  }
}
