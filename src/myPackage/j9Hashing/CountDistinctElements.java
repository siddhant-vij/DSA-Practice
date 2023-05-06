package myPackage.j9Hashing;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountDistinctElements {

  static int countDistinct(int[] A) {
    int n = A.length;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(A[i]);
    }
    return set.size();
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(countDistinct(arr));
    }
  }
}
