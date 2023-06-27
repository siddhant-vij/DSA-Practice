// Leetcode: 1441. Build an Array With Stack Operations

package myPackage.j12Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuildArrayWithStackFuncs {

  static List<String> buildArray(int[] target, int n) {
    List<String> result = new ArrayList<>();
    for (int i = 0, ptr = 0; i < n && ptr < target.length; i++) {
      if (i + 1 == target[ptr]) {
        result.add("Push");
        ptr++;
      } else {
        result.add("Push");
        result.add("Pop");
      }
    }
    return result;
  }
  
  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(buildArray(arr, k));
    }
  }  
}
