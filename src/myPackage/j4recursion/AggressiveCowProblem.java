package myPackage.j4recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCowProblem {

  static boolean isPresent(int[] arr, int n, int start, int end) {
    if (start > end)
      return false;
    else {
      int mid = start + (end - start) / 2;
      if (arr[mid] == n)
        return true;
      else if (arr[mid] > n)
        return isPresent(arr, n, start, mid - 1);
      else
        return isPresent(arr, n, mid + 1, end);
    }
  }

  static boolean isPossibleSolution(int[] arr, int mid, int k){
    int countBarrier = 1;
    int diff = 0;
    int max = arr[0];
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    for (int i = min+1; i <= max; i++) {
      Arrays.sort(arr);
      if(isPresent(arr,i,0,arr.length-1))
      {
        diff = i - min;
        if (diff >= mid) {
          countBarrier++;
          min = i;
        }
      }
    }
    return countBarrier>=k;
  }

  static int testSolution(int[] arr, int start, int end, int k, int ans){
    if (start > end)
      return ans;
    int mid = start + (end-start)/2;
    if (isPossibleSolution(arr, mid, k))
    {
      ans = mid;
      return testSolution(arr, mid + 1, end, k, ans);
    }      
    else
      return testSolution(arr, start, mid-1, k, ans);
  }

  static int aggressiveCows(ArrayList<Integer> stalls, int k){
    int length = stalls.size();
    int[] stallsArr = new int[length]; 
    for (int i = 0; i < length; i++) {
      stallsArr[i] = stalls.get(i);
    }
    int min = stallsArr[0];
    int max = stallsArr[0];
    for (int i = 1; i < stallsArr.length; i++) {
      min = Math.min(min, stallsArr[i]);
      max = Math.max(max, stallsArr[i]);
    }
    return testSolution(stallsArr, 0, max-min, k, 0);
  }
  

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int T = sc.nextInt();
      while (T-- > 0) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> stalls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          stalls.add(sc.nextInt());
        }
        System.out.println(aggressiveCows(stalls,k));
      }
    }
  }
}
