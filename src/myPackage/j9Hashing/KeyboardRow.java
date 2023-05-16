// Leetcode: 500. Keyboard Row

package myPackage.j9Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class KeyboardRow {

  static String[] findWords(String[] words) {
    String one = "qwertyuiop";
    String two = "asdfghjkl";
    String three = "zxcvbnm";
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < one.length(); i++)
      map.put(one.charAt(i), 1);
    for (int i = 0; i < two.length(); i++)
      map.put(two.charAt(i), 2);
    for (int i = 0; i < three.length(); i++)
      map.put(three.charAt(i), 3);

    List<String> list = new ArrayList<>();
    int n = words.length;
    for (int i = 0; i < n; i++) {
      int count = 1;
      int expected = -1;
      if (map.containsKey(words[i].charAt(0)))
        expected = map.get(words[i].charAt(0));
      else
        expected = map.get((char) (words[i].charAt(0) + 'a' - 'A'));
      for (int j = 1; j < words[i].length(); j++) {
        if ((map.containsKey(words[i].charAt(j))) && (map.get(words[i].charAt(j)) == expected))
          count++;
        else if ((!map.containsKey(words[i].charAt(j)))
            && (map.get((char) (words[i].charAt(j) + 'a' - 'A')) == expected))
          count++;
      }
      if (count == words[i].length())
        list.add(words[i]);
    }

    String[] result = new String[list.size()];
    for (int i = 0; i < list.size(); i++)
      result[i] = list.get(i);
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      String[] words = new String[n];
      for (int i = 0; i < words.length; i++) {
        words[i] = sc.next();
      }
      System.out.println(findWords(words));
    }
  }
}
