package myPackage.j4recursion;

import java.util.Scanner;

public class NthTermGP {
  static int nthGP (int n, int a, int r){
    if(n==1)
      return a;
    return r*nthGP(n-1, a, r);
  }
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int T = sc.nextInt();
      while (T-- > 0)
      {
        int n = sc.nextInt();
        int a = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(nthGP(n,a,r));
      }
    }
  }
}
