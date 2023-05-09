// Scaler Practice: Distinct Numbers in Window

package myPackage.j9Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DistinctNosWindow {

  static int[] dNums(int[] A, int B) {
    int n = A.length;
    int[] result = new int[n - B + 1];
    if (B > n)
      return new int[] {};
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < B; i++)
      map.put(A[i], map.getOrDefault(A[i], 0) + 1);

    result[0] = map.size();

    for (int i = B; i < n; i++) {
      if (map.get(A[i - B]) == 1)
        map.remove(A[i - B]);
      else
        map.put(A[i - B], map.get(A[i - B]) - 1);

      map.put(A[i], map.getOrDefault(A[i], 0) + 1);
      result[i + 1 - B] = map.size();
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
      int windowSize = sc.nextInt();
      System.out.println(Arrays.toString(dNums(arr, windowSize)));
    }
  }
}
