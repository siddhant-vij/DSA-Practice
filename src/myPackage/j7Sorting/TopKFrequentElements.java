// Leetcode: 347 - Top K Frequent Elements

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

class FrequentElements implements Comparable<FrequentElements> {
  int element;
  int count;

  FrequentElements(int element, int count) {
    this.element = element;
    this.count = count;
  }

  @Override
  public int compareTo(FrequentElements other) {
    if (other.count > this.count)
      return 1;
    else if (other.count < this.count)
      return -1;
    else {
      if (other.element < this.element)
        return 1;
      else if (other.element > this.element)
        return -1;
      else
        return 0;
    }
  }
}

public class TopKFrequentElements {

  static int[] countArray(int[] nums) {
    int n = nums.length;
    int min = nums[0];
    int max = nums[0];
    for (int i = 1; i < n; i++) {
      min = Math.min(min, nums[i]);
      max = Math.max(max, nums[i]);
    }
    int range = max - min + 1;
    int[] temp = new int[range];
    for (int i = 0; i < n; i++)
      temp[nums[i] - min]++;

    int[] count = new int[n];
    for (int i = 0; i < n; i++)
      count[i] = temp[nums[i] - min];

    return count;
  }

  static int[] topKFrequent(int[] nums, int k) {
    int n = nums.length;
    int[] count = countArray(nums);
    FrequentElements[] frequentelements = new FrequentElements[n];
    for (int i = 0; i < n; i++)
      frequentelements[i] = new FrequentElements(nums[i], count[i]);

    Arrays.sort(frequentelements); // O(n log n)

    for (int i = 0; i < n; i++)
      nums[i] = frequentelements[i].element;

    int[] result = new int[k];
    int cur = 0;
    int index = 0;
    while (cur < n && index < k) {
      result[index++] = nums[cur++];
      while (cur < n && index < k && nums[cur] == nums[cur - 1])
        cur++;
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
      int k = sc.nextInt();
      System.out.println(Arrays.toString(topKFrequent(arr, k)));
    }
  }
}
