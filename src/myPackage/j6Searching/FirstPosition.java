package myPackage.j6Searching;

import java.util.Arrays;
import java.util.Scanner;

public class FirstPosition {

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

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int element = sc.nextInt();
      Arrays.sort(arr);
      System.out.println(firstPositionSorted(arr, element));
    }
  }
}
