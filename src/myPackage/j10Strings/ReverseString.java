package myPackage.j10Strings;

import java.util.Scanner;

public class ReverseString {

  static String reverseString(String str) {
    char[] chArr = str.toCharArray();
    int s = 0;
    int e = chArr.length-1;
    while(s < e)
    {
      char ch = chArr[s];
      chArr[s] = chArr[e];
      chArr[e] = ch;
      s++;
      e--;
    }
    return new String(chArr);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(reverseString(str));
    }
  }
}
