package myPackage.j4Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class MinSortedRotatedArray {

  static int minimumBinary(int[] arr, int start, int end){
    if(start > end)
      return -1;
    if (start == end)
      return arr[start];
    int mid = start + (end-start)/2;
    if (mid!=end && arr[mid] > arr[mid+1])
      return arr[mid+1];
    else if (mid!=0 && arr[mid] < arr[mid-1])
      return arr[mid];
    else if (arr[mid] > arr[end])
      return minimumBinary(arr, mid+1, end);
    else
      return minimumBinary(arr, start, mid);
  }

  static int minimumLinear (int[] arr){
    int min = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min)
        min = arr[i];
    }
    return min;
  }

  static void reverseArray(int[] arr, int left, int right)
  {
    while (left < right)
    {
      int temp = arr[right];
      arr[right] = arr[left];
      arr[left] = temp;
      left++;
      right--;
    }
  }

  static void rotateArray(int[] arr, int k){
    if (k > arr.length && k%arr.length !=0)
      k = k%arr.length;
    else if (k%arr.length == 0)
      k = arr.length;
    reverseArray(arr, 0, arr.length-1);
    reverseArray(arr, 0, k-1);
    reverseArray(arr, k, arr.length-1);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      Arrays.sort(arr);
      rotateArray(arr,k);
      System.out.println(minimumLinear(arr));
      System.out.println(minimumBinary(arr,0,arr.length-1));
    }
  }
  
}
