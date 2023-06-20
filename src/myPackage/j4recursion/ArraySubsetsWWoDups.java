// Leetcode: Subsets & Subsets II

package myPackage.j4recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArraySubsetsWWoDups {

  static void subsetsDups(int[] up, int index, List<Integer> p, List<List<Integer>> result, boolean visited) {
    if (index == up.length) {
      return;
    }
    subsetsDups(up, index + 1, p, result, true);
    if(index != 0 && up[index] == up[index-1] && visited == true) {
      return;
    }
    p.add(up[index]);
    subsetsDups(up, index + 1, p, result, false);
    result.add(new ArrayList<>(p));
    p.remove(p.size() - 1);
  }

  static void subsets(int[] up, int index, List<Integer> p, List<List<Integer>> result) {
    if (index == up.length) {
      return;
    }
    p.add(up[index]);
    subsets(up, index + 1, p, result);
    result.add(new ArrayList<>(p));
    p.remove(p.size() - 1);
    subsets(up, index + 1, p, result);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
      }
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> p = new ArrayList<>();
      result.add(p);
      // subsets(arr, 0, new ArrayList<>(), result);
      // System.out.println(result);
      Arrays.sort(arr);
      subsetsDups(arr, 0, new ArrayList<>(), result, false);
      System.out.println(result);
    }
  }
}
