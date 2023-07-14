// Leetcode: 1315. Sum of Nodes with Even-Valued Grandparent

package myPackage.j15Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SumIfEvenGrandparent {

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

  static int sum = 0;

  static void helper(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.val % 2 == 0) {
      if (root.left != null) {
        if (root.left.left != null) {
          sum += root.left.left.val;
        }
        if (root.left.right != null) {
          sum += root.left.right.val;
        }
      }
      if (root.right != null) {
        if (root.right.left != null) {
          sum += root.right.left.val;
        }
        if (root.right.right != null) {
          sum += root.right.right.val;
        }
      }
    }
    helper(root.left);
    helper(root.right);
  }

  static int sumEvenGrandparent(TreeNode root) {
    helper(root);
    return sum;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      System.out.println(sumEvenGrandparent(root));
    }
  }
}
