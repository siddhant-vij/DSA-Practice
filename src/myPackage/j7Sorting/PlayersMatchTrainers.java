// Leetcode: 2410. Maximum Matching of Players With Trainers

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class PlayersMatchTrainers {

  static int matchPlayersAndTrainers(int[] players, int[] trainers) {
    int np = players.length;
    int nt = trainers.length;
    Arrays.sort(players);
    Arrays.sort(trainers);
    int p = 0;
    int t = 0;
    int count = 0;
    while (p < np && t < nt) {
      if (players[p] <= trainers[t]) {
        count++;
        p++;
        t++;
      } else {
        t++;
      }
    }
    return count;
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
      System.out.println(matchPlayersAndTrainers(arr1, arr2));
    }
  }  
}
