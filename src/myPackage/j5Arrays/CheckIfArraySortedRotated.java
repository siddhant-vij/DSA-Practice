// GFG Practice: Check if array is sorted and rotated

package myPackage.j5Arrays;

import java.util.Scanner;

public class CheckIfArraySortedRotated {

  static boolean checkRotatedAndSorted(int arr[]) {
    int inc = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] > arr[i]) {
        inc = 1;
        break;
      }
    }
    if (inc == 0) {
      return false;
    }

    int dec = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] < arr[i]) {
        dec = 1;
        break;
      }
    }
    if (dec == 0) {
      return false;
    }

    int count = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] > arr[i]) {
        count++;
      }
    }
    if (arr[arr.length - 1] > arr[0]) {
      count++;
    }
    if (count <= 1 || count == arr.length - 1) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(checkRotatedAndSorted(arr));
    }
  }
}
