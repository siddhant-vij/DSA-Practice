// Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
// Return the array in the form [x1,y1,x2,y2,...,xn,yn].
// Input: nums = [2,5,1,3,4,7], n = 3
// Output: [2,3,5,4,1,7] 
// Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

// Constraints:
// 1<=n<=500
// nums.length==2n
// 1<=nums[i]<=10^3


package myPackage.j5Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayShuffle {

  static int[] shuffleTwoPointer(int[] arr, int n){
    int[] result = new int[arr.length];
    for (int i = 0,j = 0; i < arr.length-1; i+=2, j++) {
      result[i] = arr[j];
      result[i+1] = arr[n+j];
    }
    return result;
  }

  static int[] shuffle(int[] arr, int n) {
    for (int i = n; i < arr.length; i++) {
      int numJumps = arr.length-1-i;
      int j = i-1;
      int cur = i;
      while(numJumps!=0)
      {
        arr[cur] ^= arr[j];
        arr[j] ^= arr[cur];
        arr[cur] ^= arr[j];

        j--;
        cur = j+1;
        numJumps--;
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      // System.out.println(Arrays.toString(shuffle(arr,k)));      
      System.out.println(Arrays.toString(shuffleTwoPointer(arr, k)));
    }
  }
  
}
