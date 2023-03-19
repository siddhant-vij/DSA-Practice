package myPackage.j4recursion;

import java.util.Scanner;

public class PrintNumbers {
  static void printNto1(int n){
    if (n == 0)
      return;
    System.out.print(n + " ");
    printNto1(n-1);
  }

  static void print1toN (int n){
    if (n == 0)
      return;
    print1toN(n-1);
    System.out.print(n + " ");
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int x = sc.nextInt();
      printNto1(x);
      System.out.println();
      print1toN(x);
    }
  }  
}
