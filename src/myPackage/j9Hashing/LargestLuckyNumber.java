// Leetcode: 1394. Find Lucky Integer in an Array

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LargestLuckyNumber {

  static int findLucky(int[] arr) {
    int n = arr.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++)
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    int maxLucky = -1;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if ((entry.getKey() == entry.getValue()) && entry.getKey() > maxLucky)
        maxLucky = entry.getKey();
    }
    return maxLucky;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(findLucky(arr));
    }
  }  
}
