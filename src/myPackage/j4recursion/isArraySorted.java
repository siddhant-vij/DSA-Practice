package myPackage.j4recursion;

import java.util.Scanner;

public class isArraySorted {

  static boolean isSorted(int[] arr, int index){
    if (index == arr.length-1)
      return true;
    return (arr[index]<=arr[index+1] && isSorted(arr, index+1));
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(isSorted(arr,0));
    }
  }
  
}
