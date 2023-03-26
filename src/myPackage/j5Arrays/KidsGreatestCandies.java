package myPackage.j5Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KidsGreatestCandies {

  static List<Boolean> kidsWithCandiesFast(int[] arr, int extra) {
    int max = arr[0];
    for (int i = 0; i < arr.length; i++) {
      max = Math.max(max, arr[i]);
    }
    List<Boolean> bool = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if((max-extra) <= arr[i])
        bool.add(true);
      else
        bool.add(false);
    }
    return bool;
  }

  static List<Boolean> kidsWithCandiesSlow(int[] arr, int extra) {
    List<Boolean> bool = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      int curSum = 0;
      bool.add(true);
      for (int j = 0; j < arr.length; j++) {
        curSum = extra + arr[i];
        if(i!=j && curSum < arr[j])
        {
          bool.set(i, false);
          break;
        }
      }
    }
    return bool;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int extra = sc.nextInt();
      System.out.println(kidsWithCandiesSlow(arr, extra));
      System.out.println(kidsWithCandiesFast(arr, extra));
    }
  }
  
}
