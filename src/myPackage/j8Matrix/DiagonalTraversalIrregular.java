// Leetcode: 1424. Diagonal Traverse II

package myPackage.j8Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Triplets implements Comparable<Triplets> {
  int gap;
  int row;
  int val;

  Triplets(int gap, int row, int val) {
    this.gap = gap;
    this.row = row;
    this.val = val;
  }

  @Override
  public int compareTo(Triplets other) {
    if (this.gap > other.gap)
      return 1;
    else if (this.gap < other.gap)
      return -1;
    else {
      if (this.row > other.row)
        return -1;
      else if (this.row < other.row)
        return 1;
      else
        return 0;
    }
  }
}

public class DiagonalTraversalIrregular {

  static int[] findDiagonalOrder(List<List<Integer>> nums) {
    List<Triplets> tuples = new ArrayList<>();
    for (int i = 0; i < nums.size(); i++) {
      for (int j = 0; j < nums.get(i).size(); j++) {
        tuples.add(new Triplets(i + j, i, nums.get(i).get(j)));
      }
    }
    Collections.sort(tuples);
    int n = tuples.size();
    int[] result = new int[n];
    for (int i = 0; i < n; i++)
      result[i] = tuples.get(i).val;
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      List<List<Integer>> nums = new ArrayList<>();
      int n = sc.nextInt();
      for (int i = 0; i < n; i++) {
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < m; j++) {
          list.add(sc.nextInt());
        }
        nums.add(list);
      }
      System.out.println(Arrays.toString(findDiagonalOrder(nums)));
    }
  }
}
