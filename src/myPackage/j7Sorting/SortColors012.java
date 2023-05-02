package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SortColors012 {

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  static int[] sortColors(int[] arr) {
    int n = arr.length;
    int zero = 0;
    int two = n-1;
    int cur = 0;
    while(cur <= two)
    {
      if(arr[cur] == 0)
      {
        swap(arr, zero, cur);
        zero++;
        cur++;
      }
      else if (arr[cur] == 2)
      {
        swap(arr, two, cur);
        two--;
      }
      else
        cur++;
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
      System.out.println(Arrays.toString(sortColors(arr)));
    }
  } 
}
