// Leetcode: 832 - Flipping an Image

package myPackage.j8Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class FlippingImage {

  static int[][] flipAndInvertImage(int[][] image) {
    int n = image.length;
    int[][] result = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = n - 1; j >= 0; j--) {
        if (image[i][j] == 1) {
          result[i][n - 1 - j] = 0;
        } else {
          result[i][n - 1 - j] = 1;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[][] mat = new int[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          mat[i][j] = sc.nextInt();
        }
      }
      System.out.println(Arrays.deepToString(flipAndInvertImage(mat)));
    }
  }
}
