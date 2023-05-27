// Leetcode: 299. Bulls and Cows

package myPackage.j9Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BullsAndCowsProblem {

  static String getHint(String secret, String guess) {
    int x = 0;
    int y = 0;
    int n = secret.length();
    Map<Character, Integer> mapS = new HashMap<>();
    Map<Character, Integer> mapG = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (secret.charAt(i) == guess.charAt(i))
        x++;
      else {
        mapS.put(secret.charAt(i), mapS.getOrDefault(secret.charAt(i), 0) + 1);
        mapG.put(guess.charAt(i), mapG.getOrDefault(guess.charAt(i), 0) + 1);
      }
    }
    for (Map.Entry<Character, Integer> entry : mapG.entrySet()) {
      char ch = entry.getKey();
      int freq = entry.getValue();
      if (mapS.containsKey(ch)) {
        y += Math.min(mapS.get(ch), freq);
      }
    }
    return x + "A" + y + "B";
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str1 = sc.next();
      String str2 = sc.next();
      System.out.println(getHint(str1, str2));
    }
  }
}
