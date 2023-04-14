package myPackage.j4recursion;

import java.util.Scanner;

public class BaseCases {

  static int factorial (int n, int result){
    if(n==0)
      return result;
    return factorial(n-1, result*n);
  }

  static int nthFib (int n){
    if (n<=1)
      return n;
    return nthFib(n-1)+nthFib(n-2);
  }

  static int nSum (int n){
    if (n<=1)
      return n;
    return n+nSum(n-1);
  }
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)){
      int x = sc.nextInt();
      System.out.println(factorial(x, 1));
      System.out.println(nthFib(x));
      System.out.println(nSum(x));
    }
  }
}