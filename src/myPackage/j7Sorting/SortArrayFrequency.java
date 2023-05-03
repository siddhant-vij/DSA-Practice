// Leetcode: 1636 - Sort Array by Increasing Frequency

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

class Pair implements Comparable<Pair> {
  int element;
  int count;

  Pair(int element, int count) {
    this.element = element;
    this.count = count;
  }

  @Override
  public int compareTo(Pair other) {
    if (this.count > other.count)
      return 1;
    else if (this.count < other.count)
      return -1;
    else {
      if (this.element < other.element)
        return 1;
      else if (this.element > other.element)
        return -1;
      else
        return 0;
    }
  }
}

public class SortArrayFrequency {

  static int[] frequencySort(int[] nums) {
    int n = nums.length;
    int[] count = new int[201];
    for (int i = 0; i < n; i++)
      count[nums[i] + 100]++;

    Pair[] pairs = new Pair[n];
    for (int i = 0; i < n; i++)
      pairs[i] = new Pair(nums[i], count[nums[i] + 100]);

    Arrays.sort(pairs);

    for (int i = 0; i < n; i++)
      nums[i] = pairs[i].element;

    return nums;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(frequencySort(arr)));
    }
  }
}
