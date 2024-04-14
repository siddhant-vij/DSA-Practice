package myPackage.j3Bitwise;

import java.util.Scanner;

public class KthBitSet {
  public static boolean isSet(int n, int k) {
    int k_here = 0;
    int rem_k = 0;
    while(n > 0 && k_here != k)
    {
      rem_k = n%2;
      n/=2;
      k_here++;
    }
    return rem_k==1;
  }
  
  public static boolean isSetLeft(int n, int k){
    return (n & (1 << (k - 1))) != 0;
  }
  
  public static boolean isSetRight(int n, int k){
    return (((n>>(k-1)) & 1) == 1);
  }
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      System.out.println(isSet(n,k));
      System.out.println(isSetLeft(n,k));
      System.out.println(isSetRight(n,k));
    }
  }
}
