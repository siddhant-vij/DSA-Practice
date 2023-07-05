// Leetcode: 2073. Time Needed to Buy Tickets

package myPackage.j13Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class TimeToBuyTickets {

  static class pair {
    int index;
    int value;

    pair(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }

  static int timeRequiredToBuy(int[] tickets, int k) {
    Queue<pair> q = new ArrayDeque<>();
    for (int i = 0; i < tickets.length; i++) {
      q.offer(new pair(i, tickets[i]));
    }
    int time = 0;
    while (!q.isEmpty()) {
      pair temp = q.poll();
      time += 1;
      if (temp.value > 1) {
        q.offer(new pair(temp.index, temp.value - 1));
        continue;
      }
      if (temp.value == 1) {
        if (temp.index == k)
          return time;
        continue;
      }
    }
    return time;
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      System.out.println(timeRequiredToBuy(arr, k));
    }
  }
}
