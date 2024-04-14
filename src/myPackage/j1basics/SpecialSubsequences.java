package myPackage.j1Basics;

import java.util.Scanner;

public class SpecialSubsequences {

  static int countSubsequences(String str) {
    int count = 0;
    int countg = 0;
    for (int i = str.length() - 1; i >= 0; i--) {
      if (str.charAt(i) == 'G')
        countg++;
      if (str.charAt(i) == 'A')
        count = count % 1000000007 + countg % 1000000007;
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(countSubsequences(str));
    }
  }
}
