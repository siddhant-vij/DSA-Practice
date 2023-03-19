package myPackage.j3bitwise;

import java.util.Scanner;

public class XorSumBitwiseAnd {

  static int XorSumOfBitwiseAnd(int[] a, int[] b)
  {
    int result = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b.length; j++) {
        result ^= (a[i]&b[j]);
      }      
    }
    return result;
  }

  static int XorSumOfBitwiseAndEfficient(int[] a, int[] b) {
    int aXor = 0;
    int bXor = 0;
    for (int i = 0; i < a.length; i++) {
      aXor ^= a[i];
    }
    for (int i = 0; i < b.length; i++) {
      bXor ^= b[i];
    }
    return aXor&bXor;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] arr1 = new int[n];
      int[] arr2 = new int[m];
      for (int i = 0; i < n; i++) {
        arr1[i] = sc.nextInt();
      }
      for (int i = 0; i < m; i++) {
        arr2[i] = sc.nextInt();
      }
      System.out.println(XorSumOfBitwiseAnd(arr1, arr2));
      System.out.println(XorSumOfBitwiseAndEfficient(arr1, arr2));
    }
  }
  
}
