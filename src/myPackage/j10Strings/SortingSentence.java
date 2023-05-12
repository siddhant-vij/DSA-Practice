// Leetcode: 1859. Sorting the Sentence

package myPackage.j10Strings;

import java.util.Arrays;
import java.util.Scanner;

class WordIndexPair implements Comparable<WordIndexPair> {
  String word;
  int index;

  public WordIndexPair(String word, int index) {
    this.word = word;
    this.index = index;
  }

  @Override
  public int compareTo(WordIndexPair other) {
    return this.index - other.index;
  }
}

public class SortingSentence {

  static String sortSentence(String s) {
    String[] str = s.split(" ");
    int n = str.length;
    int[] index = new int[n];
    for (int i = 0; i < n; i++) {
      StringBuilder test = new StringBuilder(str[i]);
      test.setLength(str[i].length() - 1);
      index[i] = (str[i].charAt(str[i].length() - 1) - '0') - 1;
      str[i] = test.toString();
    }

    WordIndexPair[] objs = new WordIndexPair[n];
    for (int i = 0; i < n; i++)
      objs[i] = new WordIndexPair(str[i], index[i]);
    Arrays.sort(objs);

    StringBuilder strB = new StringBuilder();
    for (int i = 0; i < n; i++)
      strB.append(objs[i].word + " ");
    strB.setLength(strB.length() - 1);
    return strB.toString();
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      System.out.println(sortSentence(str));
    }
  }  
}
