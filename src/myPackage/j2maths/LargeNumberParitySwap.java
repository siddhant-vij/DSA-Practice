// Leetcode: 2231 Largest Number After Digit Swaps by Parity

package myPackage.j2Maths;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LargeNumberParitySwap {

  static int largestInteger(int num) {
    String no = Integer.toString(num);
    String ans = "";
    int evens = 0, odds = 0;
    for (int i = 0; i < no.length(); i++) {
      if ((no.charAt(i) - '0') % 2 == 0)
        evens++;
      else
        odds++;
    }
    Integer[] even = new Integer[evens];
    Integer[] odd = new Integer[odds];
    int e = 0, o = 0;
    for (int i = 0; i < no.length(); i++) {
      if ((no.charAt(i) - '0') % 2 == 0)
        even[e++] = no.charAt(i) - '0';
      else
        odd[o++] = no.charAt(i) - '0';
    }
    Arrays.sort(even, Collections.reverseOrder());
    Arrays.sort(odd, Collections.reverseOrder());
    e = 0;
    o = 0;
    for (int i = 0; i < no.length(); i++) {
      if ((no.charAt(i) - '0') % 2 == 0) {
        ans += even[e++];
      } else
        ans += odd[o++];
    }
    return Integer.valueOf(ans);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      System.out.println(largestInteger(N));
    }
  }
}
