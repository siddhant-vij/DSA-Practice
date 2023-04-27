// Chinese Remainder Theorem

package myPackage.j2maths;

import java.util.Arrays;
import java.util.Scanner;

public class ChineseRemainder {

  private static int modularInverseNP(int a, int b, int t1, int t2) {
    if (b == 0)
      return t1;
    return modularInverseNP(b, a % b, t2, t1 - t2 * (a / b));
  }

  private static boolean isPrime(int n) {
    if (n == 1)
      return false;
    if (n == 2 || n == 3)
      return true;
    if (n % 2 == 0 || n % 3 == 0)
      return false;
    for (int i = 5; i * i <= n; i++) {
      if (n % i == 0 || n % (i + 2) == 0)
        return false;
    }
    return true;
  }

  public static int modularInverseP(int x, int n) {
    int result = 1;
    int num = n;
    n = n - 2;
    while (n > 0) {
      if ((n & 1) == 1) {
        result = (result * x) % num;
      }
      n = n >> 1;
      x = (x * x) % num;
    }
    return result;
  }

  static int chineseRemainderTheorem(int[] nums, int[] rem) {
    int M = 1;
    for (int i = 0; i < rem.length; i++)
      M *= rem[i];

    int[] Mi = new int[rem.length];
    for (int i = 0; i < rem.length; i++) {
      Mi[i] = M / rem[i];
    }

    int[] MiTemp = new int[rem.length];
    for (int i = 0; i < rem.length; i++) {
      MiTemp[i] = Mi[i];
    }

    int[] Minv = new int[rem.length];
    for (int i = 0; i < rem.length; i++) {
      int inverse = 0;
      int b = rem[i];
      if (isPrime(rem[i]))
        inverse = modularInverseP(Mi[i], rem[i]); // Fermat's Little Theorem
      else {
        if (Mi[i] > rem[i])
          inverse = modularInverseNP(Mi[i], rem[i], 0, 1); // Extended Euclidean Algorithm
        else
          inverse = modularInverseNP(rem[i], Mi[i], 0, 1); // Extended Euclidean Algorithm
      }
      Minv[i] = inverse < 0 ? b + inverse : inverse;
    }
    System.out.println(Arrays.toString(Minv));

    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      result += nums[i] * MiTemp[i] * Minv[i];
    }
    return result % M;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] num = new int[n];
      for (int i = 0; i < num.length; i++) {
        num[i] = sc.nextInt();
      }
      int[] rem = new int[n];
      for (int i = 0; i < rem.length; i++) {
        rem[i] = sc.nextInt();
      }
      System.out.println(chineseRemainderTheorem(rem, num));
    }
  }
}
