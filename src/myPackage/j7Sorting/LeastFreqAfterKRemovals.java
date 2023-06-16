// Leetcode: 1481. Least Number of Unique Integers after K Removals

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeastFreqAfterKRemovals {

  static int findLeastNumOfUniqueInts(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int n = arr.length;
    for (int i = 0; i < n; i++)
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    n = map.size();
    int[] freq = new int[n];
    int idx = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet())
      freq[idx++] = entry.getValue();
    Arrays.sort(freq);
    for (int i = 1; i < n; i++)
      freq[i] += freq[i - 1];
    int index = Arrays.binarySearch(freq, k);
    if (index >= 0)
      return n - 1 - index;
    else {
      index = -1 * (index + 1);
      return n - index;
    }
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(findLeastNumOfUniqueInts(arr, k));
    }
  }
}
