package myPackage.j4recursion;

import java.util.*;

public class FirstAndLastPositionArray {

  static int lastPosition(int[] arr, int k, int start, int end) {
    if (start > end)
      return -1;
    int mid = start + (end - start) / 2;
    if (arr[mid] == k && mid != arr.length - 1 && arr[mid+1] != k)
      return mid;
    else if (arr[mid] == k && mid == arr.length - 1)
      return mid;
    else if (arr[mid] == k && mid != arr.length-1 && arr[mid+1] == k)
      return lastPosition(arr, k, mid + 1, end);
    else if (arr[mid] < k)
      return lastPosition(arr, k, mid + 1, end);
    else
      return lastPosition(arr, k, start, mid-1);

  }

  static int firstPosition(int[] arr, int k, int start, int end) {
    if (start > end)
      return -1;
    int mid = start + (end - start) / 2;
    if (arr[mid] == k && mid != 0 && arr[mid - 1] != k)
      return mid;
    else if (arr[mid] == k && mid == 0)
      return mid;
    else if (arr[mid] == k && mid != 0 && arr[mid - 1] == k)
      return firstPosition(arr, k, start, mid-1);
    else if (arr[mid] < k)
      return firstPosition(arr, k, mid + 1, end);
    else
      return firstPosition(arr, k, start, mid - 1);

  }

  static int[] firstAndLastPositionRecursive (int[] arr, int n, int k) {
    int[] result = new int[2];
    result[0] = firstPosition(arr, k, 0, n-1);
    result[1] = lastPosition(arr, k, 0, n-1);
    return result;
  }

  static int[] firstAndLastPositionIterative(int[] arr, int n, int k) {
    int first = -1;
    int last = -1;
    for (int i = 0; i < n; i++) {
      if (i != 0) {
        if (arr[i] == k && arr[i - 1] != k)
          first = i;
      } else {
        if (arr[i] == k)
          first = i;
      }
      if (i != n - 1) {
        if (arr[i] == k && arr[i + 1] != k)
          last = i;
      } else {
        if (arr[i] == k)
          last = i;
      }
    }
    int[] result = new int[2];
    result[0] = first;
    result[1] = last;
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int T = sc.nextInt();
      while (T-- > 0) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(firstAndLastPositionIterative(arr, n, k)));
        System.out.println(Arrays.toString(firstAndLastPositionRecursive(arr, n, k)));        
      }
    }
  }
}
