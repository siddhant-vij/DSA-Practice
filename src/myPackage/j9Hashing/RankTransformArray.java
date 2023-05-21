// Leetcode: 1331. Rank Transform of an Array

package myPackage.j9Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class RankTransformArray {

  static int[] arrayRankTransformShort(int[] arr) {
    int[] A = Arrays.copyOf(arr, arr.length);
    Arrays.sort(A);
    HashMap<Integer, Integer> rank = new HashMap<>();
    for (int x : A)
      rank.putIfAbsent(x, rank.size() + 1);
    for (int i = 0; i < arr.length; ++i)
      A[i] = rank.get(arr[i]);
    return A;
  }

  static int[] arrayRankTransformLong(int[] arr) {
    int n = arr.length;
    Map<Integer, List<Integer>> map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      if (!map.containsKey(arr[i])) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        map.put(arr[i], list);
      } else {
        List<Integer> list = map.get(arr[i]);
        list.add(i);
        map.put(arr[i], list);
      }
    }
    int[] result = new int[n];
    int rank = 1;
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      List<Integer> list = entry.getValue();
      for (int i = 0; i < list.size(); i++)
        result[list.get(i)] = rank;
      rank++;
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
      System.out.println(Arrays.toString(arrayRankTransformLong(arr)));
      System.out.println(Arrays.toString(arrayRankTransformShort(arr)));
    }
  }
}
