// Pepcoding: Abbreviation 1 - Using Bits

package myPackage.j3bitwise;

import java.util.Scanner;

public class Abbreviations {

  public static void solve(String str) {
    int n = str.length();
    int power = (int) Math.pow(2, n);
    for (int i = 0; i < power; i++) {
      StringBuilder strB = new StringBuilder();
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (((i >> j) & 1) == 0) {
          if (count != 0)
            strB.append(count);
          strB.append(str.charAt(j));
          count = 0;
        } else
          count++;
      }
      if (count != 0)
        strB.append(count);
      System.out.println(strB.toString());
    }
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      solve(str);
    }
  }
}
