// Leetcode 75
// Coding Ninjas 640

package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SortColorsProblem {

  static void sortColorsOnePass(int[] arr) {
    int nextZero = 0;
    int nextTwo = arr.length - 1;
    int i = 0;
    while (i <= nextTwo) {
      if (arr[i] == 0) {
        int temp = arr[nextZero];
        arr[nextZero] = arr[i];
        arr[i] = temp;
        i++;
        nextZero++;
      } else if (arr[i] == 2) {
        int temp = arr[nextTwo];
        arr[nextTwo] = arr[i];
        arr[i] = temp;
        nextTwo--;
      } else {
        i++;
      }
    }
  }

  static void sortColorsTwoPass(int[] nums) {
    int[] count = new int[3];
    for (int i = 0; i < nums.length; i++) {
      count[nums[i]]++;
    }

    int k = 0;
    for (int j = 0; j < count.length; j++) {
      while (count[j]-- > 0) {
        nums[k++] = j;
      }
    }
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(arr));
      // sortColorsTwoPass(arr);
      sortColorsOnePass(arr);
      System.out.println(Arrays.toString(arr));
    }
  }
}
