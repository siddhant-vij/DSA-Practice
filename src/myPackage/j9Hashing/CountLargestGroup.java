// Leetcode: 1399. Count Largest Group

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountLargestGroup {

  static int countLargestGroup(int n) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      int sum = 0;
      if (i <= 9)
        sum = i;
      else {
        int num = i;
        while (num != 0) {
          sum += num % 10;
          num /= 10;
        }
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    int max = Integer.MIN_VALUE;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > max)
        max = entry.getValue();
    }
    int count = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == max)
        count++;
    }
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      System.out.println(countLargestGroup(N));
    }
  }  
}
