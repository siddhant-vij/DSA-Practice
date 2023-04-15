package myPackage.j6Searching;

import java.util.Arrays;
import java.util.Scanner;

public class CountOccurences {

  static int lastPositionSorted(int[] arr, int element) {
    int s = 0;
    int e = arr.length - 1;
    if (arr.length == 0)
      return -1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (m == arr.length - 1 && arr[m] == element)
        return m;
      else if (m != arr.length - 1 && arr[m] == element && arr[m + 1] == element)
        s = m + 1;
      else if (m != arr.length - 1 && arr[m] == element && arr[m + 1] != element)
        return m;
      else if (arr[m] < element)
        s = m + 1;
      else
        e = m - 1;
    }
    return -1;
  }

  static int firstPositionSorted(int[] arr, int element) {
    int s = 0;
    int e = arr.length - 1;
    if (arr.length == 0)
      return -1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (m == 0 && arr[m] == element)
        return m;
      else if (m != 0 && arr[m] == element && arr[m - 1] == element)
        e = m - 1;
      else if (m != 0 && arr[m] == element && arr[m - 1] != element)
        return m;
      else if (arr[m] < element)
        s = m + 1;
      else
        e = m - 1;
    }
    return -1;
  }

  static int countTotal(int[] arr, int element) {
    int start = firstPositionSorted(arr, element);
    int end = lastPositionSorted(arr, element);
    if (start == -1 && end == -1)
      return 0;
    else
      return end - start + 1;
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
      System.out.println(countTotal(arr, element));
    }
  }
}
