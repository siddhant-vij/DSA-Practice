package myPackage.j2Maths;

import java.util.Scanner;

public class LCM {
  public static int gcd (int a, int b){
    if (b == 0)
      return a;
    return gcd(b, a%b);
  }
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.println((a*b)/gcd(a,b));
    }
  }
}

/* Brute Force Approach
public class LCM {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int lcm = a*b;
    for (int i = 2; i <= Math.min(a,b) ; i++) {
      if ((a % i == 0 && b % i == 0))
      {
        lcm = lcm / i;
      }
    }
    System.out.println(lcm);
  }
}*/
