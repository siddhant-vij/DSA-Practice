// Leetcode: 654. Maximum Binary Tree

package myPackage.j15Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxBinaryTree {

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

  static void levelOrderLineByLine(TreeNode root) {
    if (root == null)
      return;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    while (queue.size() > 1) {
      TreeNode cur = queue.remove();
      if (cur == null) {
        queue.add(null);
        System.out.println();
        continue;
      }
      System.out.print(cur.val + " ");
      if (cur.left != null)
        queue.add(cur.left);
      if (cur.right != null)
        queue.add(cur.right);
    }
  }

  static int max(int[] nums, int s, int e) {
    int maxIdx = s;
    for (int i = s; i <= e; i++) {
      if (nums[maxIdx] < nums[i])
        maxIdx = i;
    }
    return maxIdx;
  }

  static TreeNode helper(int[] nums, int s, int e) {
    if (s > e)
      return null;
    int maxIdx = max(nums, s, e);
    TreeNode root = new TreeNode(nums[maxIdx]);
    root.left = helper(nums, s, maxIdx - 1);
    root.right = helper(nums, maxIdx + 1, e);
    return root;
  }

  static TreeNode constructMaximumBinaryTree(int[] nums) {
    return helper(nums, 0, nums.length - 1);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
      }
      levelOrderLineByLine(constructMaximumBinaryTree(arr));
    }
  }
  
}
