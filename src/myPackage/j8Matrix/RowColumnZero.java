// Scaler Practice
// You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0.
// Specifically, make entire ith row and jth column zero.

// Problem Constraints
// 1<=A.size()<=10^3
// 1<=A[i].size()<=10^3
// 0<=A[i][j]<=10^3

package myPackage.j8Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RowColumnZero {

  static int[][] modify(int[][] mat) {
    List<Integer> rowZero = new ArrayList<>();
    List<Integer> colZero = new ArrayList<>();
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        if (mat[i][j] == 0) {
          rowZero.add(i);
          colZero.add(j);
        }
      }
    }
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        for (int p = 0; p < rowZero.size(); p++) {
          if (i == rowZero.get(p) || j == colZero.get(p))
            mat[i][j] = 0;
        }
      }
    }
    return mat;
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
      System.out.println(Arrays.deepToString(modify(mat)));
    }
  }
}
