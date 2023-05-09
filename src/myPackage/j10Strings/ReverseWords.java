// GFG Practice: Reverse words in a given string

package myPackage.j10Strings;

import java.util.Scanner;

public class ReverseWords {

  static String reverseWords(String str) {
    String[] strArr = str.split("\\.");
    int s = 0;
    int e = strArr.length - 1;
    while (s < e) {
      String ch = strArr[s];
      strArr[s] = strArr[e];
      strArr[e] = ch;
      s++;
      e--;
    }
    StringBuilder strB = new StringBuilder();
    int n = strArr.length;
    for (int i = 0; i < n; i++) {
      if (i != n - 1)
        strB.append(strArr[i] + ".");
      else
        strB.append(strArr[i]);
    }
    return strB.toString();
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(reverseWords(str));
    }
  }
}
