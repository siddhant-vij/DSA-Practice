// Leetcode: 461 - Hamming Distance
// Leetcode: 477 - Total Hamming Distance

package myPackage.j3bitwise;

import java.util.Scanner;

public class HammingDistance {

  static int sumHDBitsFast(int[] nums) {
    int sum = 0;
    int n = nums.length;
    for (int i = 0; i < 32; i++) {
      int k = 0;
      for (int j = 0; j < nums.length; j++) {
        if (((nums[j] >> i) & 1) == 1)
          k++;
      }
      sum += k * (n - k);
    }
    return sum;
  }

  static int sumHDBitsSlow(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int xor = nums[i] ^ nums[j];
        while (xor != 0) {
          if ((xor & 1) == 1)
            sum++;
          xor >>= 1;
        }
      }
    }
    return sum;
  }

  static int countHDBitsIII(int x, int y) {
    int n = x ^ y;
    int count = 0;
    while (n != 0) {
      if ((n & 1) == 1)
        count++;
      n >>= 1;
    }
    return count;
  }

  static int countHDBitsII(int x, int y) {
    int n = x ^ y;
    int totalBits = 1 + (int) (Math.floor(Math.log(n) / Math.log(2)));
    int count = 0;
    for (int i = 0; i <= totalBits; i++) {
      if (((n >> i) & 1) == 1)
        count++;
    }
    return count;
  }

  static int countHDBitsI(int x, int y) {
    int n = Math.max(x, y);
    int totalBits = 1 + (int) (Math.floor(Math.log(n) / Math.log(2)));
    int count = 0;
    for (int i = 0; i <= totalBits; i++) {
      int xBit = x >> i;
      int yBit = y >> i;
      if ((xBit & 1) == 0 && (yBit & 1) == 1)
        count++;
      if ((xBit & 1) == 1 && (yBit & 1) == 0)
        count++;
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int x = sc.nextInt();
      int y = sc.nextInt();
      System.out.println(countHDBitsI(x, y));
      System.out.println(countHDBitsII(x, y));
      System.out.println(countHDBitsIII(x, y));
      System.out.println(sumHDBitsSlow(arr));
      System.out.println(sumHDBitsFast(arr));
    }
  }
}
