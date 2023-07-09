// Leetcode: 113. Path Sum II

package myPackage.j15Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class PathSumII {

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  static TreeNode buildTree(String str) {
    if (str.length() == 0 || str.charAt(0) == 'N') {
      return null;
    }
    String ip[] = str.split(" ");
    TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int i = 1;
    while (queue.size() > 0 && i < ip.length) {
      TreeNode currNode = queue.peek();
      queue.remove();
      String currVal = ip[i];
      if (!currVal.equals("N")) {
        currNode.left = new TreeNode(Integer.parseInt(currVal));
        queue.add(currNode.left);
      }
      i++;
      if (i >= ip.length)
        break;
      currVal = ip[i];
      if (!currVal.equals("N")) {
        currNode.right = new TreeNode(Integer.parseInt(currVal));
        queue.add(currNode.right);
      }
      i++;
    }
    return root;
  }

  static void dfs(TreeNode root, List<Integer> list, int targetSum) {
    if (root == null) {
      return;
    }
    list.add(root.val);
    targetSum -= root.val;
    if (root.left == null && root.right == null && targetSum == 0) {
      result.add(new ArrayList<>(list));
    }
    dfs(root.left, list, targetSum);
    dfs(root.right, list, targetSum);
    list.remove(list.size() - 1);
  }

  static List<List<Integer>> result = new ArrayList<>();

  static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    dfs(root, new ArrayList<>(), targetSum);
    // for (int i = 0; i < result.size(); i++) {
    // int sum = 0;
    // for (int j = 0; j < result.get(i).size(); j++) {
    // sum += result.get(i).get(j);
    // }
    // if (sum != targetSum)
    // result.remove(result.get(i--));
    // }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      int k = sc.nextInt();
      System.out.println(pathSum(root, k));
    }
  }  
}
