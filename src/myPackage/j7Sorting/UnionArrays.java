// GFG Practice: Union of two arrays

package myPackage.j7Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UnionArrays {

  static ArrayList<Integer> union(int[] arr1, int[] arr2) {
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    int n1 = arr1.length;
    int n2 = arr2.length;
    int p1 = 0;
    int p2 = 0;
    ArrayList<Integer> result = new ArrayList<>();
    while(p1 < n1 || p2 < n2)
    {
      if(p1 < n1 && p2 < n2)
      {
        if(arr1[p1] == arr2[p2])
        {
          result.add(arr1[p1]);
          p1++;
          p2++;
          while(p1 < n1 && arr1[p1] == arr1[p1-1])
            p1++;
          while(p2 < n2 && arr2[p2] == arr2[p2 - 1])
            p2++;
        }
        else if (arr1[p1] < arr2[p2])
        {
          result.add(arr1[p1]);
          p1++;
          while (p1 < n1 && arr1[p1] == arr1[p1 - 1])
            p1++;
        }
        else if (arr1[p1] > arr2[p2]) {
          result.add(arr2[p2]);
          p2++;
          while (p2 < n2 && arr2[p2] == arr2[p2 - 1])
            p2++;
        }
      }
      else if (p1 < n1 && p2 >= n2) {
        result.add(arr1[p1]);
        p1++;
        while (p1 < n1 && arr1[p1] == arr1[p1 - 1])
          p1++;
      } else if (p1 >= n1 && p2 < n2) {
        result.add(arr2[p2]);
        p2++;
        while (p2 < n2 && arr2[p2] == arr2[p2 - 1])
          p2++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr1 = new int[N];
      for (int i = 0; i < N; i++) {
        arr1[i] = sc.nextInt();
      }
      int M = sc.nextInt();
      int[] arr2 = new int[M];
      for (int i = 0; i < M; i++) {
        arr2[i] = sc.nextInt();
      }
      System.out.println(union(arr1, arr2));
    }
  } 
}
