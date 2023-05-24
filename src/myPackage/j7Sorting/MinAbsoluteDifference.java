// Leetcode: 1200. Minimum Absolute Difference

package myPackage.j7Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MinAbsoluteDifference {

  static List<List<Integer>> minimumAbsDifference(int[] arr) {
    int n = arr.length;
    Arrays.sort(arr);
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < n - 1; i++)
      minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < n - 1; i++) {
      List<Integer> list = new ArrayList<>();
      if ((arr[i + 1] - arr[i]) == minDiff) {
        list.add(arr[i]);
        list.add(arr[i + 1]);
        result.add(list);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(minimumAbsDifference(arr));
    }
  }  
}
