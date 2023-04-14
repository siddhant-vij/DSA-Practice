package myPackage.j4recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ReverseArray {

  static int[] reverseRecursive(int[] arr, int left, int right){
    if(left >= right)
      return arr;
    arr[left]^=arr[right];
    arr[right]^=arr[left];
    arr[left] ^= arr[right];
    return reverseRecursive(arr, left+1, right-1);
  }

  static void reverseCollection(int[]arr){
    Collections.reverse(Arrays.asList(arr));
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(reverseRecursive(arr,0,arr.length-1)));
      reverseCollection(arr);
      System.out.println(Arrays.toString(arr));
    }
  }
}