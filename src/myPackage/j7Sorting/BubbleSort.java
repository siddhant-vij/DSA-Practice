// Bubble Sorting Algorithm
// Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping
// the adjacent elements if they are in the wrong order.

// Time Complexity: O(N2)
// Auxiliary Space: O(1)

// It can be optimized by stopping the algorithm if the inner loop didn’t cause any swap. 

// Bubble sort takes minimum time (Order of n) when elements are already sorted.
// Hence it is best to check if the array is already sorted or not beforehand, to avoid O(N2) time complexity.

// Bubble sort performs swapping of adjacent pairs without the use of any major data structure.
// Hence Bubble sort algorithm is an in-place algorithm.

// Bubble Sorting is stable.

package myPackage.j7Sorting;

public class BubbleSort {

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  static void bubbleSortRecursive(int[] arr, int n) {
    if (n == 0 || n == 1) {
      return;
    }
    for (int i = 0; i < n - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        swap(arr, i, i + 1);
      }
    }
    bubbleSortRecursive(arr, n - 1);
  }

  static void bubbleSortOptimized(int[] arr) {
    int n = arr.length;
    boolean swapped;
    for (int i = 0; i < n-1; i++) {
      swapped = false;
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swapped = true;
        }
      }
      if (swapped == false)
        break;
    }
  }

  static void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n-1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;

        }
      }
    }
  }

  public static void main(String[] args) {
    int[] x = { 5, 5, 8, 1, 3, 0, 9 };
    bubbleSort(x);
    for (int element : x) {
      System.out.print(element + " ");
    }
    System.out.println();

    int[] y = { 5, 5, 8, 1, 3, 0, 9 };
    bubbleSortOptimized(y);
    for (int element : y) {
      System.out.print(element + " ");
    }
    System.out.println();

    int[] z = { 5, 5, 8, 1, 3, 0, 9 };
    bubbleSortRecursive(z, z.length);
    for (int element : z) {
      System.out.print(element + " ");
    }
    System.out.println();
  }
}
