package myPackage.j4recursion;

import java.util.Scanner;

public class PeakIndexMountainArray {
  
  static int peakIndexRecursive (int[] arr, int start, int end){
    if (start > end)
      return -1;
    int mid = start + (end - start) / 2;
    if (mid > 0 && mid < arr.length - 1)
    {
      if (arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1])
        return mid;
      else if (arr[mid] < arr[mid+1])
        return peakIndexRecursive(arr, mid+1, end);
      else
        return peakIndexRecursive(arr, start, mid-1);
    }
    else if (mid == 0)
    {
      if (arr[mid] > arr[mid+1])
        return mid;
      else
        return peakIndexRecursive(arr, mid+1, end);
    }
    else
    {
      if (arr[mid] > arr[mid - 1])
        return mid;
      else
        return peakIndexRecursive(arr, start, mid-1);
    }
  }

  static int peakIndexIterative(int[] arr){
    int peakIndex = 0;
    for (int i = 1; i < arr.length-1; i++) {
      if (arr[i] > arr[i-1] && arr[i] > arr[i+1])
        {
          peakIndex = i;
          return peakIndex;
        }
    }
    if (arr[0] > arr[arr.length-1])
      return 0;
    else
      return arr.length-1;
  }
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(peakIndexIterative(arr));
      System.out.println(peakIndexRecursive(arr,0,arr.length-1));
    }
  }
}