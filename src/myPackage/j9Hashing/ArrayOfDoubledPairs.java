// Leetcode: 954. Array of Doubled Pairs

package myPackage.j9Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArrayOfDoubledPairs {

  static boolean canReorderDoubled(int[] arr) {
    Map<Double, Integer> map = new HashMap<>();
    int n = arr.length;
    Arrays.sort(arr);
    map.put(arr[0] * 1.0, 1);
    for (int i = 1; i < n; i++) {
      if (map.containsKey(arr[i] * 2.0)) {
        if (map.get(arr[i] * 2.0) == 1)
          map.remove(arr[i] * 2.0);
        else
          map.put(arr[i] * 2.0, map.get(arr[i] * 2.0) - 1);
      } else if (map.containsKey(arr[i] / 2.0)) {
        if (map.get(arr[i] / 2.0) == 1)
          map.remove(arr[i] / 2.0);
        else
          map.put(arr[i] / 2.0, map.get(arr[i] / 2.0) - 1);
      } else {
        map.put(arr[i] * 1.0, map.getOrDefault(arr[i] * 1.0, 0) + 1);
      }
    }
    return map.size() == 0;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(canReorderDoubled(arr));
    }
  }  
}
