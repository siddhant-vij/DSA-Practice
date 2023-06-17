package myPackage.j5Arrays;

import java.util.Scanner;

public class ReverseArray {
  public static int[] reverseArray(int[] arr){
    int left = 0;
    int right = arr.length - 1;
    while (left < right){
      int temp = arr[right];
      arr[right] = arr[left];
      arr[left] = temp;
      left++;
      right--;
    }
    return arr;
  }
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int[] outArr = reverseArray(arr);
      for (int element: outArr) {
        System.out.print(element + " ");
      }
    }
  }
}