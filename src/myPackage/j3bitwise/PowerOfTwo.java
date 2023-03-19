package myPackage.j3bitwise;

import java.util.Scanner;

public class PowerOfTwo {
  public static boolean isTwoPower(int n){
    int rem = 0;
    while (n > 1)
    {
      rem += n % 2;
      n /= 2;
    }
    return (rem==0&&n!=0);
  }
  public static boolean isTwoPowerZero(int n){
    return (((n & (n-1)) == 0) && n != 0);
  }
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(isTwoPower(n));
      System.out.println(isTwoPowerZero(n));
    }
  }
}
