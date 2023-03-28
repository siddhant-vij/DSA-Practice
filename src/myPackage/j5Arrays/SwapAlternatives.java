// Coding Ninjas: 382

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SwapAlternatives {

  static int[] swap(int[] arr) {
    for (int i = 0; i < arr.length; i += 2) {
      if ((i + 1) != arr.length) {
        arr[i] ^= arr[i + 1];
        arr[i + 1] ^= arr[i];
        arr[i] ^= arr[i + 1];
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(swap(arr)));
    }
  }
}
