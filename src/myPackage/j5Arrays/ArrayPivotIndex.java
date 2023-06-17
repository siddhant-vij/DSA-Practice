package myPackage.j5Arrays;

import java.util.Scanner;

public class ArrayPivotIndex {

  static int pivotIndexShort(int[] arr) {
    int[] prefixSum = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      if (i==0)
        prefixSum[i] = arr[i];
      else
        prefixSum[i] += prefixSum[i-1] + arr[i];
    }
    for (int i = 0; i < prefixSum.length; i++) {
      if (i != 0 && i != arr.length - 1)
      {
        if (prefixSum[i - 1] == (prefixSum[prefixSum.length - 1] - prefixSum[i]))
          return i;
      }
      else if (i == 0)
      {
        if (0 == (prefixSum[prefixSum.length - 1] - prefixSum[0]))
          return 0;
      }
      else
      {
        if (0 == prefixSum[i - 1])
          return arr.length-1;
      }     
    }
    return -1;
  }

  static int pivotIndexLong(int[] arr) {
    int[] leftSum = new int[arr.length];
    int[] rightSum = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (i != j) {
          if (i == 0) {
            leftSum[i] = 0;
            rightSum[i] += arr[j];
          } else if (i == arr.length - 1) {
            leftSum[i] += arr[j];
            rightSum[i] = 0;
          } else {
            if (j < i)
              leftSum[i] += arr[j];
            else
              rightSum[i] += arr[j];
          }
        }
      }
    }
    for (int i = 0; i < arr.length; i++) {
      if (leftSum[i] == rightSum[i])
        return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(pivotIndexLong(arr));
      System.out.println(pivotIndexShort(arr));
    }
  }
}