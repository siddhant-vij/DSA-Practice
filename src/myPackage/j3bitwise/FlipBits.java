package myPackage.j3bitwise;

import java.util.Scanner;

public class FlipBits {
  public static int flipBits(int n){
    int x = 0;
    int pow = 0;
    while(n>0){
      int rem = n%2;
      n/=2;
      if (rem == 1)
        x += 0*Math.pow(2,pow++);
      else
        x += 1*Math.pow(2,pow++);
    }
    return x;
  }
  
  public static int value(int n){
    int value = 0;
    int pow = 1;
    int x = (int)Math.floor((Math.log(n)/Math.log(2))+1);
    for (int i = 1; i <= x; i++) {
      value += pow;
      pow = pow*2;
    }
    return value;
  }

  static int solve(int n){
    int num = 0;
    int totalBits = (int)(1+Math.floor(Math.log(n)/Math.log(2)));
    for (int i = 0; i < totalBits; i++) {
      num += (1<<i);
    }
    return num;
  }
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      System.out.println(flipBits(N));
      System.out.println(value(N)-N);
      System.out.println(solve(N)-N);
    }
  }
}