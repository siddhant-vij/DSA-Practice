// Leetcode: 506. Relative Ranks

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RelativeRanks {

  static String[] findRelativeRanks(int[] score) {
    int n = score.length;
    Integer[] temp = new Integer[n];
    for (int i = 0; i < n; i++)
      temp[i] = score[i];
    Arrays.sort(temp, Collections.reverseOrder());
    Map<Integer, String> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (i == 0)
        map.put(temp[i], "Gold Medal");
      else if (i == 1)
        map.put(temp[i], "Silver Medal");
      else if (i == 2)
        map.put(temp[i], "Bronze Medal");
      else
        map.put(temp[i], Integer.toString(i + 1));
    }
    String[] result = new String[n];
    for (int i = 0; i < n; i++)
      result[i] = map.get(score[i]);
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(findRelativeRanks(arr));
    }
  }  
}
