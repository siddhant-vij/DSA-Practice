// Leetcode: 33 - Search in Rotated Sorted Array
// Leetcode: 81 - Search in Rotated Sorted Array II

package myPackage.j6Searching;

import java.util.Scanner;

public class SearchRotatedSorted {

  static int binarySearch(int[] arr, int target, int start, int end) {
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (target < arr[mid]) {
        end = mid - 1;
      } else if (target > arr[mid]) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  static int findPivotWithDuplicates(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (mid < end && arr[mid] > arr[mid + 1]) {
        return mid;
      }
      if (mid > start && arr[mid] < arr[mid - 1]) {
        return mid - 1;
      }
      if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
        if (start < end && arr[start] > arr[start + 1]) {
          return start;
        }
        start++;
        if (end > start && arr[end] < arr[end - 1]) {
          return end - 1;
        }
        end--;
      } else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

  static int findPivot(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (mid < end && arr[mid] > arr[mid + 1]) {
        return mid;
      }
      if (mid > start && arr[mid] < arr[mid - 1]) {
        return mid - 1;
      }
      if (arr[mid] <= arr[start]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }

  static int searchWithDuplicates(int[] nums, int target) {
    int pivot = findPivotWithDuplicates(nums);
    if (pivot == -1) {
      return binarySearch(nums, target, 0, nums.length - 1);
    }
    if (nums[pivot] == target) {
      return pivot;
    }
    if (target >= nums[0]) {
      return binarySearch(nums, target, 0, pivot - 1);
    }

    return binarySearch(nums, target, pivot + 1, nums.length - 1);
  }

  static int search(int[] nums, int target) {
    int pivot = findPivot(nums);
    if (pivot == -1) {
      return binarySearch(nums, target, 0, nums.length - 1);
    }
    if (nums[pivot] == target) {
      return pivot;
    }
    if (target >= nums[0]) {
      return binarySearch(nums, target, 0, pivot - 1);
    }
    return binarySearch(nums, target, pivot + 1, nums.length - 1);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int target = sc.nextInt();
      System.out.println(search(arr, target));
      System.out.println(searchWithDuplicates(arr, target));
    }
  }
}
