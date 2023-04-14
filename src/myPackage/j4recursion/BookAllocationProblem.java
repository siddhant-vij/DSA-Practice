package myPackage.j4recursion;

import java.util.*;

public class BookAllocationProblem {

  static boolean isPossibleSolution(int mid, int[] arr, int n) {
    int countBarrier = 1;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (sum > mid)
      {
        countBarrier++;
        sum = arr[i];
      }
    }
    return (countBarrier<=n);
  }

  static long solutionSpace(int[] arr, int start, int end, int n) {
    if (start > end)
      return -1;
    if (start == end)
      return start;
    int mid = start + (end - start) / 2;
    long ans;
    if (isPossibleSolution(mid, arr, n)) {
      ans = solutionSpace(arr, start, mid, n);
    } else {
      return solutionSpace(arr, mid+1, end, n);
    }
    return ans;
  }

  static long testSolution(int n, int m, int[] time) {
    int sumOfTime = 0;
    int min = time[0];
    for (int i = 0; i < time.length; i++) {
      sumOfTime += time[i];
      min = Math.min(min, time[i]);
    }
    return solutionSpace(time, min, sumOfTime, n);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int T = sc.nextInt();
      while (T-- > 0) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] time = new int[m];
        for (int i = 0; i < m; i++) {
          time[i] = sc.nextInt();
        }
        System.out.println(testSolution(n, m, time));
      }
    }
  }

}
