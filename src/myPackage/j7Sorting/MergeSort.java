// Merge Sort Algorithm
// The Merge Sort algorithm is a sorting algorithm that is based on the Divide and Conquer paradigm.
// In this algorithm, the array is initially divided into two equal halves and then they are combined in a sorted manner.

// Time Complexity: O(N log(N))
// Auxiliary Space: O(n)
// Merge Sort is a recursive algorithm and time complexity can be expressed as following recurrence relation.
// T(n) = 2T(n/2) + θ(n)

// Is Merge sort In Place?: No, In merge sort the merging step requires extra space to store the elements.

// Is Merge sort Stable?: Yes, merge sort is stable.

// Solution of the drawback for additional storage: Use linked list.
// Quick Sort is preferred for Arrays and Merge Sort for Linked Lists.

package myPackage.j7Sorting;

public class MergeSort {

  static void merge(int arr[], int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    int L[] = new int[n1];
    int R[] = new int[n2];

    for (int i = 0; i < n1; ++i)
      L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = arr[m + 1 + j];

    int p1 = n1 - 1;
    int p2 = n2 - 1;
    int p3 = r;
    while (p3 >= l) {
      if (p1 < 0) {
        arr[p3] = R[p2];
        p2--;
      } else if (p2 < 0) {
        arr[p3] = L[p1];
        p1--;
      } else {
        if (L[p1] > R[p2]) {
          arr[p3] = L[p1];
          p1--;
        } else {
          arr[p3] = R[p2];
          p2--;
        }
      }
      p3--;
    }
  }

  static void mergeSort(int arr[], int l, int r) {
    if (l < r) {
      int m = l + (r - l) / 2;
      mergeSort(arr, l, m);
      mergeSort(arr, m + 1, r);
      merge(arr, l, m, r);
    }
  }

  public static void main(String[] args) {
    int[] x = { 5, 5, 8, 1, 3, 0, 9 };
    mergeSort(x, 0, x.length - 1);
    for (int element : x) {
      System.out.print(element + " ");
    }
    System.out.println();
  }
}
