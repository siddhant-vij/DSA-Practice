// Insertion Sort Algorithm
// The array is virtually split into a sorted and an unsorted part.
// Values from the unsorted part are picked and placed at the correct position in the sorted part.

// Insertion sort is adaptive in nature, i.e. it is appropriate for data sets which are already partially sorted.

// Time Complexity: O(N^2) 
// Auxiliary Space: O(1)

// Insertion sort takes maximum time to sort if elements are sorted in reverse order.
// And it takes minimum time (Order of n) when elements are already sorted.

// Is Insertion Sort an in-place sorting algorithm?: Yes,insertion sort is an in-place sorting algorithm.

// Is Insertion Sort a stable algorithm?: Yes,insertion sort is a stable sorting algorithm.

package myPackage.j7Sorting;

import java.util.Arrays;

public class InsertionSort {

  static int binarySearch(int a[], int item, int low, int high) {
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (item == a[mid])
        return mid + 1;
      else if (item > a[mid])
        low = mid + 1;
      else
        high = mid - 1;
    }
    return low;
  }

  static void binaryInsertionSortIterative(int[] a) {
    int i, loc, j, selected;
    int n = a.length;

    for (i = 1; i < n; i++) {
      j = i - 1;
      selected = a[i];
      loc = binarySearch(a, selected, 0, j);
      while (j >= loc) {
        a[j + 1] = a[j];
        j--;
      }
      a[j + 1] = selected;
    }
  }

  static void binaryInsertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int x = arr[i];
      int j = Math.abs(Arrays.binarySearch(arr, 0, i, x) + 1);
      System.arraycopy(arr, j, arr, j + 1, i - j);
      arr[j] = x;
    }
  }

  static void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }

  public static void main(String[] args) {
    int[] x = { 5, 5, 8, 1, 3, 0, 9 };
    insertionSort(x);
    for (int element : x) {
      System.out.print(element + " ");
    }
    System.out.println();

    int[] y = { 5, 5, 8, 1, 3, 0, 9 };
    binaryInsertionSort(y);
    for (int element : y) {
      System.out.print(element + " ");
    }
    System.out.println();

    int[] z = { 5, 5, 8, 1, 3, 0, 9 };
    binaryInsertionSortIterative(z);
    for (int element : z) {
      System.out.print(element + " ");
    }
    System.out.println();
  }
}