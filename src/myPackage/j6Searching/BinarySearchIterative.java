package myPackage.j6Searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchIterative {

  static int isPresentBinarySearch(int[] arr, int x) {
    int low = 0;
    int n = arr.length;
    int high = n - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == x)
        return mid;
      else if (arr[mid] > x)
        high = mid - 1;
      else
        low = mid + 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int element = sc.nextInt();
      Arrays.sort(arr);
      System.out.println(isPresentBinarySearch(arr, element));
    }
  }
}
