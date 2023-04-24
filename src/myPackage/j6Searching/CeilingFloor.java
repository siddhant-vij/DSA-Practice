package myPackage.j6Searching;

import java.util.Arrays;
import java.util.Scanner;

public class CeilingFloor {

  static int floorNumberII(int[] arr, int element) {
    int index = Arrays.binarySearch(arr, element);
    if (index < 0) {
      index = -1 * (index + 1);
      return index == 0 ? -1 : arr[index - 1];
    }
    return arr[index];
  }

  static int floorNumberI(int[] arr, int element) {
    int s = 0;
    int e = arr.length - 1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (arr[m] == element)
        return arr[m];
      else if (arr[m] > element)
        e = m - 1;
      else
        s = m + 1;
    }
    if (e >= 0)
      return arr[e];
    else
      return -1;
  }

  static int ceilingNumberII(int[] arr, int element) {
    int index = Arrays.binarySearch(arr, element);
    if (index < 0)
      index = -1 * (index + 1);
    return arr[index];
  }

  static int ceilingNumberI(int[] arr, int element) {
    int s = 0;
    int e = arr.length - 1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (arr[m] == element)
        return arr[m];
      else if (arr[m] > element)
        e = m - 1;
      else
        s = m + 1;
    }
    if (s < arr.length)
      return arr[s];
    else
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
      System.out.println(ceilingNumberI(arr, element));
      System.out.println(ceilingNumberI(arr, element));
      System.out.println(floorNumberI(arr, element));
      System.out.println(floorNumberII(arr, element));
    }
  }
}
