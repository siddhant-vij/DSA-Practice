// Leetcode: 1805. Number of Different Integers in a String

package myPackage.j10Strings;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountIntegersInString {

  static int numDifferentIntegers(String word) {
    Set<BigInteger> set = new HashSet<>();
    BigInteger num = BigInteger.valueOf(-1);
    int n = word.length();
    for (int i = 0; i < n; i++) {
      if (word.charAt(i) >= '0' && word.charAt(i) <= '9') {
        if (num.compareTo(BigInteger.valueOf(-1)) == 0)
          num = BigInteger.valueOf(0);
        num = num.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(word.charAt(i) - '0'));
      } else {
        if (num.compareTo(BigInteger.valueOf(-1)) != 0) {
          set.add(num);
          num = BigInteger.valueOf(-1);
        }
      }
    }
    if (num.compareTo(BigInteger.valueOf(-1)) != 0)
      set.add(num);
    return set.size();
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String word = sc.next();
      System.out.println(numDifferentIntegers(word));
    }
  }
}
