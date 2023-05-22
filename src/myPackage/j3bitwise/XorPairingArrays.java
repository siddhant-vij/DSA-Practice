// Leetcode: 2425. Bitwise XOR of All Pairings

package myPackage.j3bitwise;

import java.util.Scanner;

public class XorPairingArrays {

  static int xorAllNums(int[] nums1, int[] nums2) {
    int n1 = nums1.length;
    int n2 = nums2.length;
    int xor = 0;
    if ((n1 & 1) != 0) {
      for (int i = 0; i < n2; i++)
        xor ^= nums2[i];
    }
    if ((n2 & 1) != 0) {
      for (int i = 0; i < n1; i++)
        xor ^= nums1[i];
    }
    return xor;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr1 = new int[n];
      for (int i = 0; i < arr1.length; i++) {
        arr1[i] = sc.nextInt();
      }
      int[] arr2 = new int[n];
      for (int i = 0; i < arr2.length; i++) {
        arr2[i] = sc.nextInt();
      }
      System.out.println(xorAllNums(arr1, arr2));
    }
  }

}
