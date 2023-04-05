// Leetcode 318: Maximum Product of Word Lengths

package myPackage.j5Arrays;

import java.util.Scanner;

public class MaxProductWordLength {

  static int maxProduct(String[] words) {
    int maxProd = 0;
    int n = words.length;
    int[] mask = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        mask[i] |= (1 << (words[i].charAt(j) - 'a'));
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if ((mask[i] & mask[j]) == 0) {
          int curProd = words[i].length() * words[j].length();
          maxProd = Math.max(maxProd, curProd);
        }
      }
    }
    return maxProd;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      String[] arr = new String[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.next();
      }
      System.out.println(maxProduct(arr));
    }
  }
}
