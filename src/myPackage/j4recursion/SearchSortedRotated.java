package myPackage.j4recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchSortedRotated {
  
  static int minimumBinary(int[] arr, int start, int end) {
    if (start > end)
      return -1;
    if (start == end)
      return start;
    int mid = start + (end - start) / 2;
    if (mid != end && arr[mid] > arr[mid + 1])
      return mid + 1;
    else if (mid != 0 && arr[mid] < arr[mid - 1])
      return mid;
    else if (arr[mid] > arr[end])
      return minimumBinary(arr, mid + 1, end);
    else
      return minimumBinary(arr, start, mid);
  }

  static int find(int[] arr, int k, int start, int end) {
    if (start > end)
      return -1;
    else {
      int mid = start + (end - start) / 2;
      if (arr[mid] == k)
        return mid;
      else if (arr[mid] > k)
        return find(arr, k, start, mid - 1);
      else
        return find(arr, k, mid + 1, end);
    }
  }

  static int findPosition(ArrayList<Integer> arr, int n, int k) {
    int[] arrL = new int[arr.size()];
    for (int i = 0; i < n; i++) {
      arrL[i] = arr.get(i);
    }
    int pivot = minimumBinary(arrL, 0, n - 1);
    if (arrL[pivot] == k)
      return pivot;
    else if (k > arrL[pivot] && k <= arrL[arrL.length - 1])
      return find(arrL, k, pivot, arrL.length - 1);
    else
      return find(arrL, k, 0, pivot - 1);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      // int x = sc.nextInt();
      // System.out.println(x ^ (x >> 1));
      int n = sc.nextInt();
      ArrayList<Integer> arr = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        arr.add(sc.nextInt());
      }
      int k = sc.nextInt();
      System.out.println(findPosition(arr, arr.size(), k));
    }
  }
  
}
