// Scaler Practice: K-th Symbol
// Problem Constraints
// 1<=A<=10^5
// 0<=B<=min(2^(A-1) - 1,10^18)

package myPackage.j4recursion;

import java.util.Scanner;

public class KthSymbol {

  static long pow(long A, long B) {
    if (A == 0)
      return 0;
    if (B == 0L)
      return 1;
    long result = 1L;
    while (B > 0) {
      if ((B & 1) == 1)
        result *= A;
      A = A * A;
      B >>= 1;
    }
    return result;
  }

  static int countSetBits(int n) {
    int count = 0;
    while (n != 0) {
      count++;
      n = n & (n - 1);
    }
    return count;
  }

  static int kthSymbol(int A, int B) {
    if (B <= pow(10L, 18L))
      return countSetBits(B) & 1;
    else
      return (A - 1) % 2;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int A = sc.nextInt();
      int B = sc.nextInt();
      System.out.println(kthSymbol(A, B));
    }
  }
}
