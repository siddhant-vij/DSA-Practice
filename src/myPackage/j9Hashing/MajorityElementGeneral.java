// Pepcoding: Majority Element General

package myPackage.j9Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElementGeneral {

  static ArrayList<Integer> majorityGeneral(int[] arr, int k) {
    int n = arr.length;
    ArrayList<Integer> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++)
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > n / k)
        result.add(entry.getKey());
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
      int k = sc.nextInt();
      System.out.println(majorityGeneral(arr, k));
    }
  }
}
