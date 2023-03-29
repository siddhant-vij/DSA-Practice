// Leetcode 2367

package myPackage.j5Arrays;

import java.util.Scanner;

public class ArithmeticTripletProblem {

  static int arithmeticTripletsCount(int[] nums, int diff) {
    int cnt = 0;
    int[] count = new int[201];
    for (int i = 0; i < nums.length; i++) {
      count[nums[i]]++;
    }
    for (int i = 0; i < count.length - 2 * diff; i++) {
      if (count[i] == 1) {
        if (count[i] - count[i + diff] == 0 && count[i + diff] - count[i + (2 * diff)] == 0)
          cnt++;
      }
    }
    return cnt;
  }

  static int arithmeticTripletsPointers(int[] nums, int diff) {
    int count = 0;
    int pointer1 = 0, pointer2 = 1, pointer3 = 2;
    while (pointer3 < nums.length) {
      int compare = nums[pointer2] - nums[pointer1];
      if (compare == diff) {
        compare = nums[pointer3] - nums[pointer2];
        if (compare == diff) {
          pointer1++;
          pointer2++;
          pointer3++;
          count++;
        } else if (compare < diff)
          pointer3++;
        else {
          pointer1++;
          pointer2++;
          pointer3 = Math.max(pointer3, pointer2 + 1);
        }
      } else if (compare < diff) {
        pointer2++;
        pointer3 = Math.max(pointer3, pointer2 + 1);
      } else {
        pointer1++;
        pointer2 = Math.max(pointer2, pointer1 + 1);
        pointer3 = Math.max(pointer3, pointer2 + 1);
      }
    }
    return count;
  }

  static boolean isPresent(int[] arr, int n, int start, int end) {
    if (start > end)
      return false;
    else {
      int mid = start + (end - start) / 2;
      if (arr[mid] == n)
        return true;
      else if (arr[mid] > n)
        return isPresent(arr, n, start, mid - 1);
      else
        return isPresent(arr, n, mid + 1, end);
    }
  }

  static int arithmeticTripletsBinary(int[] nums, int diff) {
    int count = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      boolean hasNext = isPresent(nums, nums[i] + diff, 0, nums.length - 1);
      boolean hasNextNext = isPresent(nums, nums[i] + 2 * diff, 0, nums.length - 1);
      if (hasNext && hasNextNext)
        count++;
    }
    return count;
  }

  static int arithmeticTripletsSlow(int[] nums, int diff) {
    int count = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        if (nums[j] - nums[i] == diff) {
          for (int k = j + 1; k < nums.length; k++) {
            if (nums[k] - nums[j] == diff)
              count++;
          }
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int diff = sc.nextInt();
      System.out.println(arithmeticTripletsSlow(arr, diff));
      System.out.println(arithmeticTripletsBinary(arr, diff));
      System.out.println(arithmeticTripletsPointers(arr, diff));
      System.out.println(arithmeticTripletsCount(arr, diff));
    }
  }
}
