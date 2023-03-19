package myPackage.j3bitwise;

import java.util.Scanner;

public class OneOddOccuring {
  public static int[] countOccurence(int[] arr){
    int[] count = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (arr[i] == arr[j])
          count[i]++;
      }
    }
    return count;
  }
  public static int solve (int[] arr){
    int[] count = countOccurence(arr);
    for (int i = 0; i < count.length; i++) {
      if (count[i]%2 != 0)
        return arr[i];
    }
    return 0;
  }
  public static int solveEfficient (int[] arr){
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      result ^= arr[i];
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
      System.out.println(solve(arr));
      System.out.println(solveEfficient(arr));
    }
  }
}
