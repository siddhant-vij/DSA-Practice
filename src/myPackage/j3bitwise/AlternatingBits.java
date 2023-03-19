package myPackage.j3bitwise;

import java.util.Scanner;

public class AlternatingBits {

  static boolean hasAltBits(int n){
    while (n!=0)
    {
      if((n&1) == ((n>>1)&1))
        return false;
      n>>=1;
    }
    return true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner (System.in)) {
      int n = sc.nextInt();
      System.out.println(Integer.toBinaryString(n));
      System.out.println(hasAltBits(n));
    }
  }  
}
