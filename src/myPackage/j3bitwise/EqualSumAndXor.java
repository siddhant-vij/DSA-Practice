package myPackage.j3bitwise;

import java.util.Scanner;

public class EqualSumAndXor {
  static int countValues(int n){
    int count = 0;
    for (int i = 0; i <= n; i++) {
      if((n+i) == (n^i))
      {
        count++;
      }        
    }
    return count;
  }

  static int power (int x, int n){
    int result = 1;
    if (n == 0)
      return 1;
    while (n != 0)
    {
      if ((n&1) == 1)
        result *=x;
      n>>=1;
      x*=x;
    }
    return result;
  }

  static int countSetBits (int n){
    int count = 0;
    while (n!=0)
    {
      n = n&(n-1);
      count++;
    }
    return count;
  }

  static int countUnsetBits (int n){
    int total = (int)(1+Math.floor(Math.log(n)/Math.log(2)));
    int set = countSetBits(n);
    return total-set;
  }

  static int countValuesEfficient(int n){
    return power(2, countUnsetBits(n));
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(countValues(n));
      System.out.println(countValuesEfficient(n));
    }
  }
  
}
