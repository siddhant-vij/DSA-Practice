package myPackage.j10Strings;

import java.util.Scanner;

public class LongestCommonPrefixString {
  static String longestCommonPrefix(String[] str){
    StringBuilder prefix = new StringBuilder();
    for (int i = 0; i < str[0].length(); i++) {
      prefix.append(str[0].charAt(i));
      for (int j = 0; j < str.length; j++) {
        if(!str[j].startsWith(prefix.toString()))
        {
          prefix.setLength(prefix.length()-1);
          return prefix.toString();
        }
      }
    }
    return prefix.toString();
  }
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      String[] strArray = new String[n];
      for (int i = 0; i < n; i++) {
        strArray[i] = sc.next();
      }
      System.out.println(longestCommonPrefix(strArray));
    }
  }  
}