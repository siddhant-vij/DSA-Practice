// Problem Statement:
// You have given two positive integers N and K. Your task is to print a series of numbers 
// i.e   subtract K from N until it becomes 0 or negative then add K until it becomes N.
// You need to do this task without using any loop.

// For  N = 5 , K = 2 
// Series = [ 5, 3, 1, -1, 1, 3, 5]

package myPackage.j4recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintSeries {

  static ArrayList<Integer> printSeriesIncreasing(int n, int k, ArrayList<Integer> arr) {
    arr.add(n);
    if (n==arr.get(0))
      return arr;
    return printSeriesIncreasing(n+k, k, arr);
  }
  
  static ArrayList<Integer> printSeriesDecreasing(int n, int k, ArrayList<Integer> arr){
    arr.add(n);
    if((n-k)<=0)
      return printSeriesIncreasing(n-k, k, arr);
    return printSeriesDecreasing(n-k, k, arr);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int T = sc.nextInt();
      while (T-- > 0) {
        int N = sc.nextInt();
        int K = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println(printSeriesDecreasing(N, K, arr));
      }
    }
  }  
}