// Leetcode: 1734. Decode XORed Permutation

package myPackage.j3bitwise;

import java.util.Arrays;
import java.util.Scanner;

public class DecodeXORedPermutation {

  static int[] decode(int[] encoded) {
    int first = 0;
    int n = encoded.length + 1;
    for (int i = 1; i <= n; i++) {
      first ^= i;
    }
    for (int i = 1; i < n - 1; i += 2)
      first ^= encoded[i];

    int[] perm = new int[n];
    perm[0] = first;
    for (int i = 0; i < n - 1; i++) {
      perm[i + 1] = perm[i] ^ encoded[i];
    }
    return perm;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(decode(arr)));
    }
  }  
}
