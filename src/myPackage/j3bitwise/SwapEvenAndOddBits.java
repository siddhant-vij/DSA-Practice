package myPackage.j3bitwise;

import java.util.*;

public class SwapEvenAndOddBits {
  static int swapEvenAndOdd(int n){
    int even_bits = n&0xAAAAAAAA;
    int odd_bits = n&0x55555555;
    even_bits >>=1;
    odd_bits <<=1;
    return (even_bits|odd_bits);
  }
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(swapEvenAndOdd(n));
    }
  }
}
