package myPackage.j3bitwise;

import java.util.Scanner;

public class PowerSetGenerator {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      int n = str.length();
      int powSize = (int) Math.pow(2,n);
      for (int counter = 0; counter < powSize; counter++) {
        for (int i = 0; i < n; i++) {
          if ((counter&(1<<i)) != 0)
            System.out.print(str.charAt(i));
        }
        System.out.println();
      }
    }
  }
}
