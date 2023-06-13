// Leetcode: 2191. Sort the Jumbled Numbers

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

class OldNewPairs implements Comparable<OldNewPairs> {
  int oldNum;
  int newNum;

  OldNewPairs(int oldNum, int newNum) {
    this.oldNum = oldNum;
    this.newNum = newNum;
  }

  @Override
  public int compareTo(OldNewPairs other) {
    return this.newNum - other.newNum;
  }
}

public class JumbledBaseSorting {

  static int convertBase(int n, int[] mapping) {
    if (n == 0)
      return mapping[0];
    int res = 0;
    int pow = 1;
    while (n != 0) {
      res += pow * mapping[n % 10];
      n /= 10;
      pow *= 10;
    }
    return res;
  }

  static int[] sortJumbled(int[] mapping, int[] nums) {
    int n = nums.length;
    int[] newNums = new int[n];
    for (int i = 0; i < n; i++)
      newNums[i] = convertBase(nums[i], mapping);
    OldNewPairs[] pairs = new OldNewPairs[n];
    for (int i = 0; i < n; i++)
      pairs[i] = new OldNewPairs(nums[i], newNums[i]);
    Arrays.sort(pairs);
    for (int i = 0; i < n; i++)
      nums[i] = pairs[i].oldNum;
    return nums;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int[] test = new int[10];
      for (int i = 0; i < 10; i++) {
        test[i] = sc.nextInt();
      }
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(sortJumbled(test, arr)));
    }
  }
}
