// Leetcode: 315. Count of Smaller Numbers After Self

package myPackage.j7Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class IndexCountPairs implements Comparable<IndexCountPairs> {
  int index;
  int count;

  IndexCountPairs(int index, int count) {
    this.index = index;
    this.count = count;
  }

  @Override
  public int compareTo(IndexCountPairs other) {
    return this.index - other.index;
  }
}

public class CountSmallerNosAfterSelf {

  static void mergeAndCount(int[] nums, int l, int m, int r, int[] index, int[] count) {
    int n1 = m - l + 1;
    int n2 = r - m;
    int[] left = new int[n1];
    int[] idxL = new int[n1];
    int[] cntL = new int[n1];
    int[] right = new int[n2];
    int[] idxR = new int[n2];
    int[] cntR = new int[n2];
    for (int i = 0; i < n1; i++) {
      left[i] = nums[l + i];
      idxL[i] = index[l + i];
      cntL[i] = count[l + i];
    }
    for (int i = 0; i < n2; i++) {
      right[i] = nums[m + 1 + i];
      idxR[i] = index[m + 1 + i];
      cntR[i] = count[m + 1 + i];
    }

    int p1 = n1 - 1;
    int p2 = n2 - 1;
    int p3 = r;
    while (p3 >= l) {
      if (p1 < 0) {
        nums[p3] = right[p2];
        index[p3] = idxR[p2];
        count[p3] = cntR[p2];
        p2--;
      } else if (p2 < 0) {
        nums[p3] = left[p1];
        index[p3] = idxL[p1];
        count[p3] = cntL[p1];
        p1--;
      } else {
        if (left[p1] > right[p2]) {
          nums[p3] = left[p1];
          index[p3] = idxL[p1];
          count[p3] = cntL[p1] + (p2 + 1);
          p1--;
        } else {
          nums[p3] = right[p2];
          index[p3] = idxR[p2];
          count[p3] = cntR[p2];
          p2--;
        }
      }
      p3--;
    }
  }

  static void sortSmaller(int[] nums, int s, int e, int[] index, int[] count) {
    if (s < e) {
      int m = s + (e - s) / 2;
      sortSmaller(nums, s, m, index, count);
      sortSmaller(nums, m + 1, e, index, count);
      mergeAndCount(nums, s, m, e, index, count);
    }
  }

  static List<Integer> countSmaller(int[] nums) {
    int n = nums.length;
    int[] index = new int[n];
    for (int i = 0; i < n; i++)
      index[i] = i;
    int[] count = new int[n];
    Arrays.fill(count, 0);

    sortSmaller(nums, 0, n - 1, index, count);

    IndexCountPairs[] idxCntPairs = new IndexCountPairs[n];
    for (int i = 0; i < n; i++)
      idxCntPairs[i] = new IndexCountPairs(index[i], count[i]);
    Arrays.sort(idxCntPairs);

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; i++)
      result.add(idxCntPairs[i].count);
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(countSmaller(arr));
    }
  }
}
