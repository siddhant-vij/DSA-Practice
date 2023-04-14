package myPackage.j4recursion;

import java.util.Scanner;

public class LinearSearch {
  static boolean isPresentIterative(int[] arr, int n){
    for (int i = 0; i < arr.length; i++) {
      if(arr[i] == n)
        return true;
    }
    return false;
  }

  static boolean isPresentRecursive (int[] arr, int n, int start, int end){
    if ((arr[start] == n))
      return true;
    return ((start < end) && isPresentRecursive(arr, n, start+1, end));
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      int element = sc.nextInt();
      System.out.println(isPresentIterative(arr, element));
      System.out.println(isPresentRecursive(arr, element,0,N-1));
    }
  }  
}