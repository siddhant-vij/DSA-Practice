package myPackage.j2Maths;

import java.util.Scanner;

public class MagicNumber {
  static String decimalToBinary(int n){
    StringBuilder strB = new StringBuilder();
    while (n > 0)
    {
      int rem = n % 2;
      strB.append(rem);
      n /=2;
    }
    strB.reverse();
    return strB.toString();
  }
  static int binaryToMagic (String str){
    // return (int)str.charAt(0)-'0';
    int magic = 0; int pow = 1;
    for (int i = 0; i < str.length(); i++) {
      int ch = (int) (str.charAt(i)-'0');
      magic += ch*((int)Math.pow(5, pow++));
    }
    return magic;
  }
  static int MagicNumberMethod (int n){
    int magic = 0; int pow = 5;
    while(n != 0)
    {
      if((n&1) != 0)
      {
        magic += pow;
      }
      n >>= 1;
      pow *= 5;
    }
    return magic;
  } 
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      System.out.println(decimalToBinary(N));
      System.out.println(binaryToMagic(decimalToBinary(N)));
      System.out.println(MagicNumberMethod(N));
    }
  }
  
}
