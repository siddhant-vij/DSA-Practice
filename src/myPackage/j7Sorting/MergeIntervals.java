// Leetcode: 56. Merge Intervals

// Similar Problems
// Leetcode: 57. Insert Interval
// Leetcode: 763. Partition Labels

package myPackage.j7Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class StartEndPairs implements Comparable<StartEndPairs> {
  int start;
  int end;

  StartEndPairs(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public int compareTo(StartEndPairs other) {
    return this.start - other.start;
  }
}

public class MergeIntervals {

  static int[][] merge(int[][] intervals) {
    int n = intervals.length;
    StartEndPairs[] pairs = new StartEndPairs[n];
    for (int i = 0; i < n; i++)
      pairs[i] = new StartEndPairs(intervals[i][0], intervals[i][1]);
    Arrays.sort(pairs);
    for (int i = 0; i < n; i++) {
      intervals[i][0] = pairs[i].start;
      intervals[i][1] = pairs[i].end;
    }
    List<List<Integer>> resL = new ArrayList<>();
    for (int i = 1; i < n; i++) {
      if (intervals[i - 1][1] >= intervals[i][0]) {
        intervals[i][0] = intervals[i - 1][0];
        intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(intervals[i - 1][0]);
        list.add(intervals[i - 1][1]);
        resL.add(list);
      }
    }
    List<Integer> list = new ArrayList<>();
    list.add(intervals[n - 1][0]);
    list.add(intervals[n - 1][1]);
    resL.add(list);
    n = resL.size();
    int[][] result = new int[n][2];
    for (int i = 0; i < n; i++) {
      result[i][0] = resL.get(i).get(0);
      result[i][1] = resL.get(i).get(1);
    }
    return result;
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
      System.out.println(Arrays.deepToString(merge(arr)));
    }
  }
}
