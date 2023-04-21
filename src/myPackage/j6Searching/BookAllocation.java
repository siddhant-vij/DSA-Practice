// GFG Practice: Book Allocation Problem

package myPackage.j6Searching;

import java.util.Scanner;

public class BookAllocation {

  static boolean isPossibleSolution(int[] arr, int k, int m) {
    int walls = 1;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (sum > m) {
        walls++;
        sum = arr[i];
      }
    }
    return walls <= k;
  }

  static int binarySearchSolution(int[] arr, int k, int s, int e) {
    int result = -1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (isPossibleSolution(arr, k, m)) {
        result = m;
        e = m - 1;
      } else
        s = m + 1;
    }
    return result;
  }

  static int minPagesFast(int[] arr, int k) {
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      max = Math.max(max, arr[i]);
    }
    return binarySearchSolution(arr, k, max, sum);
  }

  static int sum(int arr[], int b, int e) {
    int s = 0;
    for (int i = b; i <= e; i++)
      s += arr[i];
    return s;
  }

  static int minPagesSlow(int[] arr, int n, int k) {
    if (k == 1)
      return sum(arr, 0, n - 1);
    if (n == 1)
      return arr[0];
    int res = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      res = Math.min(res, Math.max(minPagesSlow(arr, i, k - 1), sum(arr, i, n - 1)));
    }
    return res;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] pages = new int[N];
      for (int i = 0; i < N; i++) {
        pages[i] = sc.nextInt();
      }
      int students = sc.nextInt();
      System.out.println(minPagesSlow(pages, pages.length, students));
      System.out.println(minPagesFast(pages, students));
    }
  }
}
