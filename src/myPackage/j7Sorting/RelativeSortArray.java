// Leetcode: 1122. Relative Sort Array

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class RelativeSortArray {

  static int[] relativeSortArray(int[] arr1, int[] arr2) {
    Map<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < arr1.length; i++)
      map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);

    int idx = 0;
    for (int i = 0; i < arr2.length; i++) {
      int count = map.get(arr2[i]);
      while (count-- > 0) {
        arr1[idx++] = arr2[i];
        if (map.get(arr2[i]) == 1)
          map.remove(arr2[i]);
        else
          map.put(arr2[i], map.get(arr2[i]) - 1);
      }
    }
    if (map.size() > 0) {
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        int element = entry.getKey();
        int count = entry.getValue();
        while (count-- > 0)
          arr1[idx++] = element;
      }
    }
    return arr1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr1 = new int[N];
      for (int i = 0; i < N; i++) {
        arr1[i] = sc.nextInt();
      }
      int M = sc.nextInt();
      int[] arr2 = new int[M];
      for (int i = 0; i < M; i++) {
        arr2[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }
  }
}
