package myPackage.j2maths;

import java.util.Scanner;

public class PowerAndUnderModulo {
  public static int powerRecursion(int x, int n) {
    if (n == 0)
      return 1;
    int temp = powerRecursion(x, n / 2);
    temp = temp * temp;
    if (n % 2 == 0)
      return temp;
    else
      return x * temp;
  }
  
  public static int powerBinaryExponentiation(int x, int n){
    int result = 1;
    while (n > 0)
    {
      if ((n & 1) != 0)
      {
        result *= x;
      }
      n = n >> 1;
      x *= x;
    }
    return result;
  }
  
  public static int powerModulo(int x, int n, int m){
    int result = 1;
    while (n > 0)
    {
      if ((n & 1) != 0)
      {
        result = (result * x) % m;
      }
      n = n >> 1;
      x = (x*x)%m;
    }
    return result;
  }
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int x = sc.nextInt();
      int n = sc.nextInt();
      int m = sc.nextInt();
      System.out.println(powerRecursion(x,n));
      System.out.println(powerBinaryExponentiation(x,n));
      System.out.println(powerModulo(x,n,m));
    }
  }
}