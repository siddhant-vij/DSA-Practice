// Scaler Practice: Sub-arrays with 0 Sum

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SubArraySumZero {

  static int countSubArrayZeroSum(int[] A) {
    int n = A.length;
    int count = 0;
    long curSum = 0L;
    Map<Long, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      curSum += A[i];
      if (curSum == 0)
        count++;
      if (map.containsKey(curSum))
        count += map.get(curSum);
      map.put(curSum, map.getOrDefault(curSum, 0) + 1);
    }
    return count;
  }

  static boolean isSubArrayZeroSum(int[] A) {
    int n = A.length;
    Set<Long> set = new HashSet<>();
    long curSum = 0L;
    for (int i = 0; i < n; i++) {
      curSum += A[i];
      if (curSum == 0L)
        return true;
      set.add(curSum);
    }
    if (set.size() != A.length)
      return true;
    else
      return false;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(isSubArrayZeroSum(arr));
      System.out.println(countSubArrayZeroSum(arr));
    }
  }
}
