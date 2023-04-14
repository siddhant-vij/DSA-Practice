// Leetcode: 1689 - Partitioning Into Minimum Number Of Deci-Binary Numbers

package myPackage.j2maths;

import java.util.Scanner;

public class DeciBinary {

  static int minPartitions(String n) {
    int max = Character.getNumericValue(n.charAt(0));
    for (int i = 1; i < n.length(); i++) {
      int num = Character.getNumericValue(n.charAt(i));
      if (num > max)
        max = num;
    }
    return max;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();
      System.out.println(minPartitions(str));
    }
  }
}
