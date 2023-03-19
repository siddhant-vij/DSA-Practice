package myPackage.j3bitwise;

import java.util.Scanner;

public class CountSetBitsTillN {
  static int countSetBits(int n){
    int count = 0;
    while (n > 0)
    {
      n = (n&(n-1));
      count++;
    }
    return count;
  }
  static int countTotalSetBits(int n){
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += countSetBits(i);
    }
    return sum;
  }
  static int countTotalSetBitsEfficient (int n){
    if (n<=2) {
      return n;
    }
    else
    {
      int x = (int)Math.floor((Math.log(n))/(Math.log(2)));
      int pow = (int)Math.pow(2,x);
      return ((n-pow+1) + (pow/2*x) + countTotalSetBitsEfficient(n-pow));
    }
    
  }
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int x = sc.nextInt();
      System.out.println(countTotalSetBits(x));
      System.out.println(countTotalSetBitsEfficient(x));
    }
  }
  
}
