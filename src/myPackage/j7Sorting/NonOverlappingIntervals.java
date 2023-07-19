// Leetcode: 435. Non-overlapping Intervals

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class NonOverlappingIntervals {

  static int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
    int end = intervals[0][1];
    int count = 0;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < end) {
        count++;
      } else {
        end = intervals[i][1];
      }
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[][] arr = new int[N][2];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < 2; j++) {
          arr[i][j] = sc.nextInt();
        }
      }
      System.out.println(eraseOverlapIntervals(arr));
    }
  }
}
