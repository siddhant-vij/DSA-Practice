// Leetcode: 124. Binary Tree Maximum Path Sum

package myPackage.j15Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxPathSum {

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

  static int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftMaxSum = Math.max(0, dfs(root.left));
    int rightMaxSum = Math.max(0, dfs(root.right));
    maxSum = Math.max(maxSum, root.val + leftMaxSum + rightMaxSum);
    return root.val + Math.max(leftMaxSum, rightMaxSum);
  }

  static int maxSum = Integer.MIN_VALUE;

  static int maxPathSum(TreeNode root) {
    dfs(root);
    return maxSum;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      System.out.println(maxPathSum(root));
    }
  }
}
