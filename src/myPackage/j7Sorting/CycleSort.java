// Cycle Sort Algorithm
// It is optimal in terms of the number of memory writes. It minimizes the number of memory writes to sort
// (Each value is either written zero times if it’s already in its correct position or written one time to its correct position.)

// It is based on the idea that the array to be sorted can be divided into cycles. Cycles can be visualized as a graph.
// We have n nodes and an edge directed from node i to node j if the element at i-th index must be present at j-th index
// in the sorted array. 

// Worst Case TC: O(n2) 
// Average Case TC: O(n2) 
// Best Case TC: O(n2)
// Auxiliary Space: O(1)

// Cycle sort is an in-place and unstable sorting algorithm.

package myPackage.j7Sorting;

public class CycleSort {

  static int cycleSortWholeNos(int[] arr) {
    int writes = 0;
    int n = arr.length;
    for (int i = 0; i < n;) {
      int correctPos = arr[i];
      if (arr[i] != arr[correctPos]) {
        int temp = arr[i];
        arr[i] = arr[correctPos];
        arr[correctPos] = temp;
        writes++;
      } else
        i++;
    }
    return writes;
  }

  static int cycleSortNaturalNos(int[] arr) {
    int writes = 0;
    int n = arr.length;
    for (int i = 0; i < n;) {
      int correctPos = arr[i] - 1;
      if (arr[i] != arr[correctPos]) {
        int temp = arr[i];
        arr[i] = arr[correctPos];
        arr[correctPos] = temp;
        writes++;
      } else
        i++;
    }
    return writes;
  }

  static int cycleSortDups(int[] arr) {
    int writes = 0;
    int n = arr.length;

    for (int cycle_start = 0; cycle_start <= n - 2; cycle_start++) {
      int item = arr[cycle_start];
      int pos = cycle_start;
      for (int i = cycle_start + 1; i < n; i++)
        if (arr[i] < item)
          pos++;

      if (pos == cycle_start)
        continue;

      while (item == arr[pos])
        pos += 1;

      if (pos != cycle_start) {
        int temp = item;
        item = arr[pos];
        arr[pos] = temp;
        writes++;
      }

      while (pos != cycle_start) {
        pos = cycle_start;

        for (int i = cycle_start + 1; i < n; i++)
          if (arr[i] < item)
            pos += 1;

        while (item == arr[pos])
          pos += 1;

        if (item != arr[pos]) {
          int temp = item;
          item = arr[pos];
          arr[pos] = temp;
          writes++;
        }
      }
    }
    return writes;
  }

  static int cycleSortDistinct(int[] arr) {
    int n = arr.length;
    int writes = 0;
    for (int cs = 0; cs < n - 1; cs++) {
      int item = arr[cs];
      int pos = cs;
      for (int i = cs + 1; i < n; i++)
        if (arr[i] < item)
          pos++;

      int temp = item;
      item = arr[pos];
      arr[pos] = temp;
      writes++;

      while (pos != cs) {
        pos = cs;
        for (int i = cs + 1; i < n; i++)
          if (arr[i] < item)
            pos++;

        temp = item;
        item = arr[pos];
        arr[pos] = temp;
        writes++;
      }
    }
    return writes;
  }

  public static void main(String[] args) {
    int[] x = { 5, 8, 1, 3, 0, 9 };
    System.out.println("Number of memory writes: " + cycleSortDistinct(x));
    for (int element : x) {
      System.out.print(element + " ");
    }
    System.out.println();
    int[] y = { 5, 5, 8, 1, 3, 0, 9 };
    System.out.println("Number of memory writes: " + cycleSortDups(y));
    for (int element : y) {
      System.out.print(element + " ");
    }
    System.out.println();
    int[] z = { 3, 2, 4, 5, 1 };
    System.out.println("Number of memory writes: " + cycleSortNaturalNos(z));
    for (int element : z) {
      System.out.print(element + " ");
    }
    System.out.println();
    int[] w = { 3, 2, 4, 5, 1, 0 };
    System.out.println("Number of memory writes: " + cycleSortWholeNos(w));
    for (int element : w) {
      System.out.print(element + " ");
    }
  }
}