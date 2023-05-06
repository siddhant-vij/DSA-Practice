package myPackage.j9Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyQueries {

  static int[] findFrequency(int[] A, int[] B) {
    int n = A.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(A[i], map.getOrDefault(A[i], 0) + 1);
    }
    int m = B.length;
    int[] result = new int[m];
    for (int i = 0; i < m; i++) {
      if (map.containsKey(B[i]))
        result[i] = map.get(B[i]);
      else
        result[i] = 0;
    }
    return result;
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
      System.out.println(Arrays.toString(findFrequency(arr1, arr2)));
    }
  }
}
