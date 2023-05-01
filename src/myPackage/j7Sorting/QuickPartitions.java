// GFG Practice - Partition Function of QuickSort
// 1. Naive Partition
// 2. Two Pointer Partition
// 3. Lomuto Partition
// 3. Hoare's Partition

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuickPartitions {

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  static int partitionHoare(int[] arr, int p) {
    int l = 0;
    int h = arr.length - 1;
    swap(arr, p, l);
    int pivot = arr[l];
    int i = l - 1;
    int j = h + 1;
    while (true) {
      do {
        i++;
      } while (arr[i] < pivot);
      do {
        j--;
      } while (arr[j] > pivot);
      if (i >= j)
        return j;
      swap(arr, i, j);
    }
  }

  static void partitionLomuto(int[] arr, int p) {
    int l = 0;
    int h = arr.length - 1;
    swap(arr, p, h);
    int pivot = arr[h];
    int i = l - 1;
    for (int j = l; j <= h - 1; j++) {
      if (arr[j] < pivot) {
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, h);
  }

  static void partitionTwoPointers(int[] arr, int p) {
    int n = arr.length;
    int lp = 0;
    int gp = n - 1;
    int cur = 0;
    int element = arr[p];
    while (cur <= gp) {
      if (arr[cur] < element) {
        swap(arr, cur, lp);
        lp++;
        cur++;
      } else if (arr[cur] > element) {
        swap(arr, cur, gp);
        gp--;
      } else
        cur++;
    }
  }

  static void partitionNaive(int[] arr, int p) {
    int l = 0;
    int h = arr.length - 1;
    int[] temp = new int[h - l + 1];
    int index = 0;
    for (int i = l; i <= h; i++)
      if (arr[i] <= arr[p] && i != p) {
        temp[index] = arr[i];
        index++;
      }
    temp[index++] = arr[p];
    for (int i = l; i <= h; i++)
      if (arr[i] > arr[p]) {
        temp[index] = arr[i];
        index++;
      }
    for (int i = l; i <= h; i++)
      arr[i] = temp[i - l];
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int p = sc.nextInt();
      System.out.println(Arrays.toString(arr));

      // Perform only one partition at a time - Array Modification.

      // partitionNaive(arr, p);
      // // 3 Traversals - O(N) TC / O(N) Extra Space
      // // Doesn't work in case of duplicates - selected as pivot element
      // // Stable Partition
      // System.out.println(Arrays.toString(arr));

      partitionTwoPointers(arr, p);
      // 1 Traversal - O(N) TC / O(1) Extra Space
      // 3 Way Quick Sort Partition - Dutch National Flag (Sort 0,1,2)
      // Works for duplicates - selected as pivot element
      // Unstable Partition
      System.out.println(Arrays.toString(arr));

      // partitionLomuto(arr, p);
      // // 1 Traversal - O(N) TC / O(1) Extra Space
      // // Doesn't work in case of duplicates - selected as pivot element
      // // Unstable Partition
      // System.out.println(Arrays.toString(arr));

      // int pivot = partitionHoare(arr, p);
      // // 1 Traversal - O(N) TC / O(1) Extra Space
      // // Doesn't work in case of duplicates - selected as pivot element
      // // Unstable Partition
      // System.out.println(Arrays.toString(arr));
    }
  }
}
