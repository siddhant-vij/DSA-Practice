// Leetcode: 2331. Evaluate Boolean Binary Tree

package myPackage.j15Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EvaluateBooleanTree {

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

  static int helper(int left, int root, int right) {
    if (root == 2) {
      if (left == 0 && right == 0)
        return 0;
      else
        return 1;
    } else {
      if (left == 1 && right == 1)
        return 1;
      else
        return 0;
    }
  }

  static int dfs(TreeNode root) {
    if (root.left == null && root.right == null) {
      return root.val;
    }
    return helper(dfs(root.left), root.val, dfs(root.right));
  }

  static boolean evaluateTree(TreeNode root) {
    return dfs(root) == 0 ? false : true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      System.out.println(evaluateTree(root));
    }
  }  
}
