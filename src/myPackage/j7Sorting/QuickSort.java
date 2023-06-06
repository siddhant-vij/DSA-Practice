// QuickSort is a Divide and Conquer algorithm. It picks an element as a pivot and partitions the given array around the picked pivot. There are many different versions of quickSort that pick pivot in different ways.
// 1. Always pick the first element as a pivot. (Hoare's)
// 2. Always pick the last element as a pivot. (Lomuto)
// 3. Pick a random element as a pivot and then swap pivot element with first/last element - Hoare's/Lomuto.
// 4. Median (Middle Element). (Best Case)

// The key process in quickSort is a partition(). The target of partitions is, given an array and an element x of an array as the pivot, put x at its correct position in a sorted array and put all smaller elements (smaller than x) before x, and put all greater elements (greater than x) after x. All this should be done in linear time.

// Naive vs Lomuto vs Hoare’s Partition

// Worst Case RR: T(n) = T(n-1) + g(n)
// Worst Case TC = O(N^2)
// The worst case occurs when the partition process always picks the greatest or smallest element as the pivot.
// (Sorted Array with Lomuto & Hoare's partitioning)
// Best Case RR: T(n) = 2*T(n/2) + g(n)
// The best case occurs when the partition process always picks the middle element as the pivot.
// Average Case (Unfair Division) RR: T(n) = T(n/9) + T(9n/10) + g(n)
// Best/Average TC = O(NLogN)
// Random Pivot Selection (Average) - O(NLogN)

// Is QuickSort stable? : The default implementation is not stable. (Merge Sort is stable)

// Is QuickSort In-place? : As per the broad definition of in-place algorithm it qualifies as an in-place sorting algorithm as it uses extra space only for storing recursive function calls but not for manipulating the input.
// Aux Space for call stack: O(n). Worst Case - when the partition picks the greatest or smallest element as the pivot.
// Aux Space for call stack: O(Log n). Best Case - when the partition picks the middle element as the pivot.

// Can we reduce the auxiliary space for function call stack? We can limit the auxiliary space to O(Log n). The idea is based on tail call elimination. http://www.cs.nthu.edu.tw/~wkhon/algo08-tutorials/tutorial2b.pdf
// 1. First solves sub-problem with smaller size
// 2. Call recursion only when sub-problem is small enough
// Modern Compilers take care of this by themselves. Works only if the last statement of a recursive function is the recurive call - which is true for Quick Sort (not for Merge Sort)

// Can we implement QuickSort Iteratively? : Yes, but it requires stack data structure (Later).

// Why Quick Sort is preferred over MergeSort for sorting Arrays? Why MergeSort is preferred over QuickSort for Linked Lists?

package myPackage.j7Sorting;

public class QuickSort {

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  static int partitionHoare(int[] arr, int l, int h) {
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

  static int partitionLomuto(int[] arr, int l, int h) {
    int pivot = arr[h];
    int i = l - 1;
    for (int j = l; j <= h - 1; j++) {
      if (arr[j] < pivot) {
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, h);
    return i + 1;
  }

  static void quickSortHoare(int[] arr, int l, int h) {
    if (l < h) {
      int pivot = partitionHoare(arr, l, h);
      quickSortHoare(arr, l, pivot);
      quickSortHoare(arr, pivot + 1, h);
    }
  }

  static void quickSortLomuto(int[] arr, int l, int h) {
    if (l < h) {
      int pivot = partitionLomuto(arr, l, h);
      quickSortLomuto(arr, l, pivot - 1);
      quickSortLomuto(arr, pivot + 1, h);
    }
  }

  public static void main(String[] args) {
    int[] x = { 5, 5, 8, 1, 3, 0, 9, 2, 7, 4, 9, 6, 3, 5, 1, 0, 2, 5, 9, 6, 3, 6, 5, 4, 1, 2, 3, 6, 9, 8, 7, 4, 4 };
    quickSortLomuto(x, 0, x.length - 1);
    for (int element : x) {
      System.out.print(element + " ");
    }
    System.out.println();
    int[] y = { 5, 5, 8, 1, 3, 0, 9, 2, 7, 4, 9, 6, 3, 5, 1, 0, 2, 5, 9, 6, 3, 6, 5, 4, 1, 2, 3, 6, 9, 8, 7, 4, 4 };
    quickSortHoare(y, 0, y.length - 1);
    for (int element : y) {
      System.out.print(element + " ");
    }
  }
}
