package myPackage.j3Bitwise;

import java.util.Scanner;

public class CountSetBits {
  public static int countSetBits(int n){
    int count = 0;
    while (n > 0)
    {
      int rem = n%2;
      n/=2;
      if (rem == 1)
        count++;
    }
    return count;
  }

  public static int numberOfSetBits (int n){
    int count = 0;
    while(n>0)
    {
      if((n&1) == 1)
        count++;
      n >>= 1;
    }
    return count;
  }
  
  public static int countSetBitsBKAlgo(int n){
    int count = 0;
    while (n > 0)
    {
      n = (n&(n-1));
      count++;
    }
    return count;
  }
  
  static int []table = new int[256];
  public static void initialize() {
    table[0] = 0;
    for (int i = 0; i < 256; i++)
      table[i] = (i & 1) + table[i / 2];
  }
  public static int countSetBitsTable(int n)
  {
    return table[n & 0xff] +
            table[(n >> 8) & 0xff] +
            table[(n >> 16) & 0xff] +
            table[n >> 24];
  }
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      System.out.println(countSetBits(N));
      System.out.println(numberOfSetBits(N));
      System.out.println(countSetBitsBKAlgo(N));
      initialize();
      System.out.println(countSetBitsTable(N));
    }
  }
}
