package myPackage.j4Recursion;

import java.util.Scanner;

public class GenerateSubsets {

  static void subsetsBitwise(String str){
    for (int i = 0; i < Math.pow(2, str.length()); i++) {
      for (int j = 0; j < str.length(); j++) {
        if (((i>>j)&1) == 1)
          System.out.print(str.charAt(j));
      }
      System.out.println();
    }
  }

  static void subsetsRecursive(String str, String curr, int index){
    if (index == str.length()) {
      System.out.println(curr);
      return;
    }

    subsetsRecursive(str, curr, index + 1);
    subsetsRecursive(str, curr + str.charAt(index), index + 1);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      subsetsBitwise(str);
      System.out.println();
      subsetsRecursive(str,"",0);
    }
  }  
}
