package myPackage.j2maths;

import java.util.Scanner;

public class SquareRoot {
  
  static int sqrtRecursive(long n, long s, long e){
    if (s > e)
      return (int)e;
    long m = s + (e-s)/2;
    if (m*m == n*1L)
      return (int)m;
    else if (m*m < n*1L)
      return sqrtRecursive(n, m+1, e);
    else
      return sqrtRecursive(n, s, m-1);
  }
  
  static int sqrtIterative(long n){
    long sqrt = 0;
    for (long i = 1; i*i <= n; i++) {
      if (i*i <= n)
        sqrt = i;
    }
    return (int)sqrt;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      long N = sc.nextInt();
      System.out.println(sqrtIterative(N));
      System.out.println(sqrtRecursive(N,1L,N));
    }
  }
  
}
