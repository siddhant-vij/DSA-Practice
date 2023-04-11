// Leetcode: 661 - Image Smoother

package myPackage.j8Matrix;

import java.util.Scanner;

public class ImageSmoother {

  static boolean isValid(int row, int col, int rows, int cols) {
    return row >= 0 && row < rows && col >= 0 && col < cols;
  }

  static int[][] imageSmoother(int[][] img) {
    int rows = img.length;
    int cols = img[0].length;
    int[][] mat = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int sum = 0;
        int count = 0;
        for (int row = i - 1; row <= i + 1; row++) {
          for (int col = j - 1; col <= j + 1; col++) {
            if (isValid(row, col, rows, cols)) {
              sum += img[row][col];
              count++;
            }
          }
        }
        mat[i][j] = (int) Math.floor(sum * 1.0 / count);
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
      System.out.println(imageSmoother(mat));
    }
  }
}
