// Leetcode: 1404. Number of Steps to Reduce a Number in Binary Representation to One

package myPackage.j4recursion;

import java.math.BigInteger;
import java.util.Scanner;

public class ReduceBinaryToZero {

  static int helper(BigInteger num, int steps) {
    if (num.compareTo(BigInteger.valueOf(1)) == 0)
      return steps;
    if (num.mod(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(0)) == 0)
      return helper(num.divide(BigInteger.valueOf(2)), steps + 1);
    return helper(num.add(BigInteger.valueOf(1)), steps + 1);
  }

  static int numSteps(String s) {
    BigInteger num = new BigInteger(s, 2);
    return helper(num, 0);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String test = sc.next();
      System.out.println(numSteps(test));
    }
  }  
}
