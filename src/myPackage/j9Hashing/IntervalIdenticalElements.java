// Leetcode: 2121. Intervals Between Identical Elements

package myPackage.j9Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IntervalIdenticalElements {

  static long[] getDistancesFast(int[] arr) {
    int n = arr.length;
    long[] ans = new long[n];
    HashMap<Integer, List<Integer>> hmap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      hmap.putIfAbsent(arr[i], new ArrayList<>());
      hmap.get(arr[i]).add(i);
    }
    long next, curr, prev;
    int v, k;
    for (List<Integer> list : hmap.values()) {
      k = list.size();
      List<Long> prefixSum = new ArrayList<>();
      v = list.get(0);
      prefixSum.add((long) v);
      for (int i = 1; i < k; i++) {
        prefixSum.add(prefixSum.get(i - 1) + list.get(i));
      }
      for (int i = 0; i < k; i++) {
        prev = i == 0 ? 0 : prefixSum.get(i - 1);
        curr = list.get(i);
        next = prefixSum.get(k - 1) - prefixSum.get(i);
        ans[list.get(i)] = curr * (long) i - prev + next - curr * (long) (k - 1 - i);
      }
    }
    return ans;
  }

  static long[] getDistancesSlow(int[] arr) {
    int n = arr.length;
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (map.containsKey(arr[i])) {
        List<Integer> list = map.get(arr[i]);
        list.add(i);
        map.put(arr[i], list);
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        map.put(arr[i], list);
      }
    }
    long[] result = new long[n];
    for (int i = 0; i < n; i++) {
      List<Integer> list = map.get(arr[i]);
      for (int j = 0; j < list.size(); j++)
        result[i] += Math.abs(i - list.get(j));
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
      System.out.println(Arrays.toString(getDistancesSlow(arr)));
      System.out.println(Arrays.toString(getDistancesFast(arr)));
    }
  }
}
