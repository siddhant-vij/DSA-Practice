// Practice: Find all Indices of a Number

package myPackage.j4recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindIndicesOfNumber {

  static List<Integer> allOccurencesRecursive(int[] arr, int element, List<Integer> result, int ptr) {
    if (ptr == arr.length)
      return result;
    if (arr[ptr] == element)
      result.add(ptr);
    return allOccurencesRecursive(arr, element, result, ptr + 1);
  }

  static List<Integer> allOccurencesIterative(int[] arr, int element, List<Integer> result) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (arr[i] == element)
        result.add(i);
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(allOccurencesIterative(arr, k, new ArrayList<>()));
      System.out.println(allOccurencesRecursive(arr, k, new ArrayList<>(), 0));
    }
  }
}
