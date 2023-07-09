// Leetcode: 112. Path Sum

package myPackage.j15Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class PathSumI {

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

  static void dfs(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    list.add(root.val);
    if (root.left == null && root.right == null) {
      result.add(new ArrayList<>(list));
    }
    dfs(root.left, list);
    dfs(root.right, list);
    list.remove(list.size() - 1);
  }

  static List<List<Integer>> result = new ArrayList<>();

  static boolean hasPathSumI(TreeNode root, int targetSum) {
    // Naive Solution
    dfs(root, new ArrayList<>());
    for (int i = 0; i < result.size(); i++) {
      int sum = 0;
      for (int j = 0; j < result.get(i).size(); j++) {
        sum += result.get(i).get(j);
      }
      if (sum == targetSum)
        return true;
    }
    return false;
  }

  static boolean hasPathSumII(TreeNode root, int targetSum) {
    // Optimized Solution
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null && root.val == targetSum) {
      return true;
    }
    if (hasPathSumII(root.left, targetSum - root.val) || hasPathSumII(root.right, targetSum - root.val)) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      int k = sc.nextInt();
      System.out.println(hasPathSumI(root, k));
      System.out.println(hasPathSumII(root, k));
    }
  }
}
