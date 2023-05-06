package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstRepeatingElement {

  static int firstRepeating(int[] A) {
    int n = A.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++)
      map.put(A[i], map.getOrDefault(A[i], 0) + 1);
    for (int i = 0; i < n; i++) {
      if (map.get(A[i]) > 1)
        return A[i];
    }
    return -1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(firstRepeating(arr));
    }
  }
}
