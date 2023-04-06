package myPackage.j5Arrays;

import java.util.Scanner;

public class ArrayLeaders {

  static int countLeadersFast(int[] arr) {
    int count = 1;
    int max = arr[arr.length - 1];
    for (int i = arr.length - 2; i >= 0; i--) {
      if (arr[i] > max) {
        count++;
        max = arr[i];
      }
    }
    return count;
  }

  static int countLeadersSlow(int[] arr) {
    int count = 1;
    for (int i = 0; i < arr.length - 1; i++) {
      int max = arr[i + 1];
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] > max)
          max = arr[j];
      }
      if (arr[i] > max)
        count++;
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(countLeadersSlow(arr));
      System.out.println(countLeadersFast(arr));
    }
  }
}
