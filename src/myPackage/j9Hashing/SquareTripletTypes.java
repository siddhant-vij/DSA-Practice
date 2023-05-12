// Leetcode: 1577. Number of Ways Where Square of Number Is Equal to Product of Two Numbers

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SquareTripletTypes {

  static int numTriplets(int[] nums1, int[] nums2) {
    int n1 = nums1.length;
    int n2 = nums2.length;

    int count = 0;

    Map<Long, Integer> n1SqMap = new HashMap<>();
    for (int i = 0; i < n1; i++)
      n1SqMap.put(1L * nums1[i] * nums1[i], n1SqMap.getOrDefault(1L * nums1[i] * nums1[i], 0) + 1);
    for (Map.Entry<Long, Integer> entry : n1SqMap.entrySet()) {
      Map<Long, Integer> n2Map = new HashMap<>();
      for (int i = 0; i < n2; i++) {
        double test = entry.getKey() * 1.0 / nums2[i];
        if ((test == (int) test) && n2Map.containsKey((long) test))
          count += entry.getValue() * n2Map.get((long) test);
        n2Map.put((long) nums2[i], n2Map.getOrDefault((long) nums2[i], 0) + 1);
      }
    }

    Map<Long, Integer> n2SqMap = new HashMap<>();
    for (int i = 0; i < n2; i++)
      n2SqMap.put(1L * nums2[i] * nums2[i], n2SqMap.getOrDefault(1L * nums2[i] * nums2[i], 0) + 1);
    for (Map.Entry<Long, Integer> entry : n2SqMap.entrySet()) {
      Map<Long, Integer> n1Map = new HashMap<>();
      for (int i = 0; i < n1; i++) {
        double test = entry.getKey() * 1.0 / nums1[i];
        if ((test == (int) test) && n1Map.containsKey((long) test))
          count += entry.getValue() * n1Map.get((long) test);
        n1Map.put((long) nums1[i], n1Map.getOrDefault((long) nums1[i], 0) + 1);
      }
    }
    return count;
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
      System.out.println(numTriplets(arr1, arr2));
    }
  }  
}
