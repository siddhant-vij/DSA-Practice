// Coding Ninjas: 1871

package myPackage.j5Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PairSum {

  static int[][] pairSum(int[] arr, int target) {
    Arrays.sort(arr);
    ArrayList<ArrayList<Integer>> arrL = new ArrayList<>();
    int pos = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i+1; j < arr.length; j++) {
        if((arr[i] + arr[j]) == target)
        {
          arrL.add(new ArrayList<>());
          arrL.get(pos).add(arr[i]);
          arrL.get(pos++).add(arr[j]);
        }
      }
    }
    int[][] result = new int[arrL.size()][arrL.get(0).size()];
    for (int i = 0; i < arrL.size(); i++) {
      for (int j = 0; j < arrL.get(i).size(); j++) {
        result[i][j] = arrL.get(i).get(j);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int target = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.deepToString(pairSum(arr, target)));
    }
  }
}
