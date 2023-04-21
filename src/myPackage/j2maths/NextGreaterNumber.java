// Leetcode: 556. Next Greater Element III

package myPackage.j2maths;

import java.util.Scanner;

public class NextGreaterNumber {

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  static void reverse(int[] arr, int start, int end) {
    while (start < end) {
      swap(arr, start, end);
      start++;
      end--;
    }
  }

  static void nextPermutation(int[] arr) {
    int n = arr.length;
    int i = n - 2;
    while (i >= 0 && arr[i + 1] <= arr[i]) {
      i--;
    }
    if (i >= 0) {
      int j = arr.length - 1;
      while (arr[j] <= arr[i]) {
        j--;
      }
      swap(arr, i, j);
    }

    reverse(arr, i + 1, n - 1);
  }

  static int nextGreaterElement(int n) {
    int digits = 1 + (int) Math.floor(Math.log(n) / Math.log(10));
    int[] nums = new int[digits];
    int cur = digits - 1;
    int num = n;
    while (n != 0) {
      nums[cur--] = n % 10;
      n /= 10;
    }
    nextPermutation(nums);
    int result = 0;
    for (int i = 0; i < nums.length; i++)
      result = result * 10 + nums[i];

    if (result > num)
      return result;
    else
      return -1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      System.out.println(nextGreaterElement(N));
    }
  }
}
