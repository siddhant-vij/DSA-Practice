package myPackage.j2maths;

import java.util.Scanner;

public class ModularInverse {
  public static int modularInverse(int x, int n){
    int result = 1;
    int num = n;
    n = n - 2;
    while (n > 0)
    {
      if ((n & 1) == 1)
      {
        result = (result*x)%num;
      }
      n = n >> 1;
      x = (x*x) % num;
    }
    return result;
  }
  
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int a = sc.nextInt();
      int m = sc.nextInt();
      System.out.println(modularInverse(a,m));
    }
  }
}