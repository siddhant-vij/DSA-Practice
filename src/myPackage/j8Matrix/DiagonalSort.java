// Leetcode: 1329. Sort the Matrix Diagonally

package myPackage.j8Matrix;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DiagonalSort {

  static int[][] fillMatrix(TreeMap<Integer, TreeMap<Integer, Integer>> map, int rows, int cols) {
    int[][] mat = new int[rows][cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        int gap = col - row;
        TreeMap<Integer, Integer> inner = map.get(gap);
        Map.Entry<Integer, Integer> entry = inner.firstEntry();
        mat[row][col] = entry.getKey();
        if (entry.getValue() == 1)
          inner.remove(entry.getKey());
        else
          inner.put(entry.getKey(), entry.getValue() - 1);
      }
    }
    return mat;
  }

  static TreeMap<Integer, TreeMap<Integer, Integer>> formMap(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;
    TreeMap<Integer, TreeMap<Integer, Integer>> map = new TreeMap<>();
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < m; col++) {
        int gap = col - row;
        if (!map.containsKey(gap)) {
          TreeMap<Integer, Integer> inner = new TreeMap<>();
          inner.put(mat[row][col], inner.getOrDefault(mat[row][col], 0) + 1);
          map.put(gap, inner);
        } else {
          TreeMap<Integer, Integer> inner = map.get(gap);
          inner.put(mat[row][col], inner.getOrDefault(mat[row][col], 0) + 1);
          map.put(gap, inner);
        }
      }
    }
    return map;
  }

  static int[][] diagonalSort(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;
    return fillMatrix(formMap(mat), n, m);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      int[][] mat = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          mat[i][j] = sc.nextInt();
        }
      }
      System.out.println(Arrays.deepToString(diagonalSort(mat)));
    }
  }  
}
