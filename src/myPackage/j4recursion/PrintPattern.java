// GFG Practice: Print Pattern
// Print a sequence of numbers starting with N where A[0] = N, without using loop,
// in which  A[i+1] = A[i] - 5,  until A[i] > 0.
// After that A[i+1] = A[i] + 5  repeat it until A[i] = N.

package myPackage.j4recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PrintPattern {
  static List<Integer> pattern(int N) {
    List<Integer> result = new ArrayList<>();
    printDec(N, result);
    int M = result.get(result.size() - 1);
    printInc(M + 5, N, result);
    return result;
  }

  static List<Integer> printDec(int N, List<Integer> result) {
    if (N + 5 <= 0)
      return result;
    result.add(N);
    return printDec(N - 5, result);
  }

  static List<Integer> printInc(int N, int M, List<Integer> result) {
    if (N > M)
      return result;
    result.add(N);
    return printInc(N + 5, M, result);
  }

  public static void main(String args[]) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(in.readLine());
    while (t-- > 0) {
      int N = Integer.parseInt(in.readLine().trim());
      List<Integer> ans = new ArrayList<Integer>();
      ans = PrintPattern.pattern(N);
      for (int i = 0; i < ans.size(); i++)
        System.out.print(ans.get(i) + " ");
      System.out.println();
    }
  }
}