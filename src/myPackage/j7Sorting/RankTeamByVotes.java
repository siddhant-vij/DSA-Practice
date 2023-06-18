// Leetcode: 1366. Rank Teams by Votes

package myPackage.j7Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RankTeamByVotes {

  static String rankTeams(String[] votes) {
    if (votes.length == 0)
      return "";
    if (votes.length == 1)
      return votes[0];

    int n = votes[0].length();

    int[][] score = new int[26][n + 1];
    for (char c : votes[0].toCharArray())
      score[c - 'A'][n] = c;

    for (String vote : votes) {
      for (int i = 0; i < n; i++) {
        int team = vote.charAt(i) - 'A';
        score[team][i]++;
      }
    }

    Arrays.sort(score,
        new Comparator<int[]>() {
          @Override
          public int compare(int[] a1, int[] a2) {
            int i = 0;
            while (i < n && a1[i] == a2[i])
              i++;
            return i == n ? Integer.compare(a1[i], a2[i]) : Integer.compare(a2[i], a1[i]);
          }
        });

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append((char) score[i][n]);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      String[] arr = new String[N];
      for (int i = 0; i < N; i++) {
        arr[i] = sc.next();
      }
      System.out.println(rankTeams(arr));
    }
  }
}
