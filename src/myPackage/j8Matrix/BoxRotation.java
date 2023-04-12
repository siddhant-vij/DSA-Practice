// Leetcode: 1861 - Rotating the Box

package myPackage.j8Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class BoxRotation {

  static char[][] rotation(char[][] mat, int m, int n) {
    char[][] rotationResult = new char[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        rotationResult[i][j] = mat[m - 1 - j][i];
      }
    }
    return rotationResult;
  }

  static char[] rowModify(char[] arr) {
    int cur = 0;
    int hash = 0;
    while (cur < arr.length) {
      if (arr[cur] == '*') {
        hash = cur + 1;
      } else if (arr[cur] != '#') {
        char temp = arr[cur];
        arr[cur] = arr[hash];
        arr[hash] = temp;
        hash++;
      }
      cur++;
    }
    return arr;
  }

  static char[][] rotateTheBox(char[][] box) {
    int m = box.length;
    int n = box[0].length;
    char[][] intermediate = new char[m][];
    for (int i = 0; i < m; i++) {
      char[] arr = new char[n];
      for (int j = 0; j < n; j++) {
        arr[j] = box[i][j];
      }
      intermediate[i] = new char[n];
      intermediate[i] = rowModify(arr);
    }
    return rotation(intermediate, m, n);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      char[][] mat = new char[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          mat[i][j] = sc.next().charAt(0);
        }
      }
      System.out.println(Arrays.deepToString(rotateTheBox(mat)));
    }
  }
}
