// Selection Sort Algorithm
// The selection sort algorithm sorts an array by repeatedly finding the minimum element
// (considering ascending order) from the unsorted part and putting it at the beginning. 

// The algorithm maintains two subarrays in a given array.
// 1. The subarray which already sorted. 
// 2. The remaining subarray was unsorted.

// In every iteration of the selection sort, the minimum element (considering ascending order)
// from the unsorted subarray is picked and moved to the sorted subarray.

// Selection Sort Algorithm - in place?: Yes, it does not require extra space.

// Stability: The default implementation is not stable. However, it can be made stable.

package myPackage.j7Sorting;

public class SelectionSort {

  static void selectionSortStable(int[] a) {
    int n = a.length;
    for (int i = 0; i < n - 1; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++)
        if (a[min] > a[j])
          min = j;

      int key = a[min];
      while (min > i) {
        a[min] = a[min - 1];
        min--;
      }

      a[i] = key;
    }
  }

  static void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int min_idx = i;
      for (int j = i + 1; j < n; j++)
        if (arr[j] < arr[min_idx])
          min_idx = j;

      int temp = arr[min_idx];
      arr[min_idx] = arr[i];
      arr[i] = temp;
    }
  }

  public static void main(String[] args) {
    int[] x = { 5, 5, 8, 1, 3, 0, 9 };
    selectionSort(x);
    for (int element : x) {
      System.out.print(element + " ");
    }
    System.out.println();

    int[] y = { 5, 5, 8, 1, 3, 0, 9 };
    selectionSortStable(y);
    for (int element : y) {
      System.out.print(element + " ");
    }
    System.out.println();
  }
}
