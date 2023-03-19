package myPackage.j3bitwise;

import java.util.Scanner;

public class OneSingleRestThrice {
  static void printOneRestThrice(int[] arr){
    for (int k : arr) {
      int count = 0;
      for (int i : arr) {
        if (k == i)
          count++;
      }
      if (count == 1)
        System.out.println(k);
    }
  }
  static int getSingleRestThrice(int[] arr){
    int ones = 0, twos = 0;
    int common_bit_mask;
    for (int j : arr) {
      twos = twos | (ones & j);
      ones = ones ^ j;
      common_bit_mask = ~(ones & twos);
      ones &= common_bit_mask;
      twos &= common_bit_mask;
    }
    return ones; //Returns those value which appear ONLY once
//    return twos; //Returns those value which appear ONLY twice
  }
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      printOneRestThrice(arr);
      System.out.println(getSingleRestThrice(arr));
    }
  }
}
