package myPackage.j2maths;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EulerTotient {

  static List<Integer> primeFactors(int n) {
    List<Integer> factors = new ArrayList<>();
    if (n == 1)
      return factors;
    while (n % 2 == 0) {
      factors.add(2);
      n /= 2;
    }
    while (n % 3 == 0) {
      factors.add(3);
      n /= 3;
    }
    int factor = 5;
    while (n > 1 && factor * factor <= n) {
      while (n % factor == 0) {
        factors.add(factor);
        n /= factor;
      }
      if (n % (factor + 2) == 0) {
        factors.add(factor + 2);
        n /= (factor + 2);
      } else
        factor += 6;
    }
    if (n > 3)
      factors.add(n);
    return factors;
  }

  static boolean isPrime(int n) {
    if (n == 1)
      return false;
    if (n == 2 || n == 3)
      return true;
    if (n % 2 == 0 || n % 3 == 0)
      return false;
    for (int i = 5; i * i <= n; i += 6) {
      if (n % i == 0 || n % (i + 2) == 0)
        return false;
    }
    return true;
  }

  static int countCoPrimesII(int n) {
    if (isPrime(n))
      return n - 1;
    List<Integer> primeFactors = primeFactors(n);
    int count = (int) (n * (1 - (1.0 / primeFactors.get(0))));
    for (int i = 1; i < primeFactors.size(); i++) {
      if (primeFactors.get(i) != primeFactors.get(i - 1))
        count *= (1 - (1.0 / primeFactors.get(i)));
    }
    return count;
  }

  static int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  static int countCoPrimesI(int n) {
    int count = 0;
    for (int i = 1; i < n; i++) {
      if (gcd(i, n) == 1)
        count++;
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(countCoPrimesI(n));
      System.out.println(countCoPrimesII(n));
    }
  }
}
