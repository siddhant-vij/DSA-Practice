package myPackage.j4recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimumCookingTime {

  static boolean isPossibleSolution(int[] arr, int mid, int k) {
    int sumCount[] = new int[arr.length];
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 1; ; j++) {
        sumCount[i] += arr[i]*j;
        if(sumCount[i]<=mid)
          count++;
        else
          break;
      } 
    }
    return count>=k;
  }

  static int testSolution(int[] arr, int start, int end, int k, int ans) {
    if (start > end)
      return ans;
    int mid = start + (end - start) / 2;
    if (isPossibleSolution(arr, mid, k)) {
      ans = mid;
      return testSolution(arr, start, mid - 1, k, ans);
    } else
      return testSolution(arr, mid + 1, end, k, ans);
  }

  static int minCookTime(ArrayList<Integer> rank, int m) {
    int length = rank.size();
    int[] rankArr = new int[length];
    for (int i = 0; i < length; i++) {
      rankArr[i] = rank.get(i);
    }
    int min = rankArr[0];
    int product = m;
    for (int i = 0; i < rankArr.length; i++) {
      min = Math.min(min, rankArr[i]);
      product *= rankArr[i];
    }
    return testSolution(rankArr, min, product, m, 0);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int T = sc.nextInt();
      while (T-- > 0) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> rank = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          rank.add(sc.nextInt());
        }
        System.out.println(minCookTime(rank, m));
      }
    }
  }
  
}
