package myPackage.j3bitwise;

import java.util.Scanner;

public class TwoOddOccurring {
  public static void solve(int[] arr){
    for (int k : arr) {
      int count = 0;
      for (int i : arr) {
        if (k == i)
          count++;
      }
      if (count % 2 != 0)
        System.out.print(k + " ");
    }
    System.out.println();
  }
  public static void solveEfficient(int[] arr){
    int result1;
    int result2;
    int xor = result1 = result2 = 0;
    for (int j : arr) {
      xor ^= j;
    }
    int sn = xor & (-xor);
    for (int j : arr) {
      if ((j & sn) != 0)
        result1 ^= j;
      else
        result2 ^= j;
    }
    System.out.println(result1 + " " + result2);
  }
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      solve(arr);
      solveEfficient(arr);
    }
  }
}