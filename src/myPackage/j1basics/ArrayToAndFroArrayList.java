package myPackage.j1Basics;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayToAndFroArrayList {
  public static ArrayList<ArrayList<Integer>> twoDArrayToList(int[][] pattern) {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    for (int[] ints : pattern) {
      ArrayList<Integer> list = new ArrayList<>();
      for (int i : ints) {
        list.add(i);
      }
      lists.add(list);
    }
    return lists;
  }
  public static int[][] twoDListToArray(ArrayList<ArrayList<Integer>> pattern) {
    int[][] arrays = new int[pattern.size()][pattern.get(0).size()];
    int indexOuter = 0;
    for (ArrayList<Integer> ints : pattern) {
      int indexInner = 0;
      for (int i : ints) {
        arrays[indexOuter][indexInner++] = i;
      }
      indexOuter++;
    }
    return arrays;
  }
  public static void main(String[] args) {
    int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
    System.out.println(twoDArrayToList(A));
    System.out.println(Arrays.deepToString(twoDListToArray(twoDArrayToList(A))));
  }
}
