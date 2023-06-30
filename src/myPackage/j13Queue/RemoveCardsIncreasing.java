// Leetcode: 950. Reveal Cards In Increasing Order

package myPackage.j13Queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class RemoveCardsIncreasing {

  static int[] deckRevealedIncreasing(int[] deck) {
    int N = deck.length;
    Deque<Integer> index = new LinkedList<>();
    for (int i = 0; i < N; ++i)
      index.add(i);
    int[] ans = new int[N];
    Arrays.sort(deck);
    for (int card : deck) {
      ans[index.pollFirst()] = card;
      if (!index.isEmpty())
        index.add(index.pollFirst());
    }
    return ans;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(Arrays.toString(deckRevealedIncreasing(arr)));
    }
  }  
}
