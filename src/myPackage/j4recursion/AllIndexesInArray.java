package myPackage.j4recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllIndexesInArray {

  static List<Integer> allIndexes(int[] arr, int idx, int k, List<Integer> result) {
    if (idx == arr.length) {
      return result;
    }
    if (arr[idx] == k) {
      result.add(idx);
    }
    return allIndexes(arr, idx + 1, k, result);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(allIndexes(arr, 0, k, new ArrayList<>()));
    }
  }
}
