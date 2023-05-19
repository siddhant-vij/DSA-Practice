// Leetcode: 1287. Element Appearing More Than 25% In Sorted Array

package myPackage.j5Arrays;

import java.util.Scanner;

public class SpecialInteger {

  static int findSpecialInteger(int[] arr) {
    int count = 1;
    int n = arr.length;
    if (n == 1)
      return arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] == arr[i - 1])
        count++;
      else
        count = 1;
      if (count > n / 4)
        return arr[i];
    }
    return -1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(findSpecialInteger(arr));
    }
  }
}
