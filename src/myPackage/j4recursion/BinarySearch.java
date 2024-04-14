package myPackage.j4Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

  static boolean isPresentBinarySearch(int[] arr, int n, int start, int end){
    if(start > end)
      return false;
    else
    {
      int mid = start + (end-start)/2;
      if (arr[mid] == n)
        return true;
      else if (arr[mid] > n)
        return isPresentBinarySearch(arr, n, start, mid-1);
      else
        return isPresentBinarySearch(arr, n, mid+1, end);
    }
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
      System.out.println(isPresentBinarySearch(arr, element,0,N-1));
    }
  }  
}
