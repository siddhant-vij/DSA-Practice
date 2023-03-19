package myPackage.j3bitwise;

import java.util.Scanner;

public class SumOfBitDifference {

  static int countSetBits(int n){
    int count = 0;
    while (n > 0)
    {
      n = (n&(n-1));
      count++;
    }
    return count;
  }
  static int sumBitDiff(int[] arr){
      int sum = 0; 
      for(int i=0; i<arr.length; i++){
        for(int j=0; j<i; j++){
          sum += 2*countSetBits(arr[i]^arr[j]);
        }
      }
      return sum;
    }

    static int sumBitDiffEfficient(int arr[])
    {
      int ans = 0;
      int n = arr.length;
      for (int i = 0; i < 32; i++) {
        int count = 0;
        for (int j = 0; j < n; j++)
            if ((arr[j] & (1 << i)) != 0)
                count++;
        ans += (count * (n - count) * 2);
      }
      return ans;
    }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(sumBitDiff(arr));
      System.out.println(sumBitDiffEfficient(arr));
    }
  }  
}
