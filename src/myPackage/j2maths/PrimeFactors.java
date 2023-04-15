package myPackage.j2maths;

import java.util.ArrayList;

public class PrimeFactors {
  public static ArrayList<Integer> primeFactors(int n) {
    ArrayList<Integer> factors = new ArrayList<>();
    if (n <= 1)
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
      } else {
        factor += 6;
      }
    }
    if (n > 3)
      factors.add(n);
    return factors;
  }

  public static void main(String[] args) {
    int n = 19269250;
    System.out.println(primeFactors(n));
  }

  /*
   * Optimized code but unwanted loop iterations can be removed
   * public static ArrayList<Integer> primeFactors(int n){
   * ArrayList<Integer> factors = new ArrayList<>();
   * int factor = 2;
   * while (n > 1 || factor*factor <= n)
   * {
   * if (n%factor == 0)
   * {
   * factors.add(factor);
   * n /= factor;
   * }
   * else
   * {
   * factor++;
   * }
   * }
   * return factors;
   * }
   */
}