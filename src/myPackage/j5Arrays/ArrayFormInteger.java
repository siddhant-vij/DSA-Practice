// Leetcode 989

package myPackage.j5Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayFormInteger {

  static List<Integer> addToArrayForm(int[] num, int k) {
    List<Integer> arrL = new ArrayList<>();
    for (int i = num.length - 1; i >= 0; i--) {
      arrL.add((num[i] + k) % 10);
      k = (num[i] + k) / 10;
    }
    while (k > 0) {
      arrL.add(k % 10);
      k /= 10;
    }
    Collections.reverse(arrL);
    return arrL;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(addToArrayForm(arr, k));
    }
  }
}
