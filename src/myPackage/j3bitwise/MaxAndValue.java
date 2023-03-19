package myPackage.j3bitwise;

import java.util.Scanner;

public class MaxAndValue {
  public static int maxAndValue(int[] arr){
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i+1; j < arr.length; j++) {
        if ((arr[i]&arr[j]) > max)
          max = arr[i]&arr[j];
      }
    }
    return max;
  }
  public static int checkBit (int pattern, int[] arr){
    int count = 0;
    for (int j : arr) {
      if ((pattern & j) == pattern)
        count++;
    }
    return count;
  }
  public static int maxAndValueEfficient(int[] arr){
    int result = 0, count;
    for (int i = 31; i >= 0; i--) {
      count = checkBit((result|(1<<i)), arr);
      if (count >= 2)
        result |= (1 << i);
    }
    return result;
  }
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(maxAndValue(arr));
      System.out.println(maxAndValueEfficient(arr));
    }
  }
}
