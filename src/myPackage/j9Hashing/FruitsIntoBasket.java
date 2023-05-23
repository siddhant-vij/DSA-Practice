// Leetcode: 904. Fruit Into Baskets

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FruitsIntoBasket {

  static int totalFruit(int[] fruits) {
    int n = fruits.length;
    int s = 0;
    int e = 1;
    int maxLength = Integer.MIN_VALUE;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(fruits[s], 1);
    while (s < n && e < n) {
      if (!map.containsKey(fruits[e])) {
        map.put(fruits[e], 0);
      }
      if (map.containsKey(fruits[e]) && map.size() <= 2) {
        map.put(fruits[e], map.get(fruits[e]) + 1);
        e++;
      } else {
        maxLength = Math.max(maxLength, e - s);
        while (s < n && map.get(fruits[s]) > 0) {
          map.put(fruits[s], map.get(fruits[s]) - 1);
          if (map.get(fruits[s]) == 0) {
            map.remove(fruits[s]);
            s++;
            break;
          }
          s++;
        }
      }
    }
    maxLength = Math.max(maxLength, e - s);
    return maxLength;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(totalFruit(arr));
    }
  }
}
