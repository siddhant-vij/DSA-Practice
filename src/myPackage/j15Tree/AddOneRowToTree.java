// Leetcode: 623. Add One Row to Tree

package myPackage.j15Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AddOneRowToTree {

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
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

  static TreeNode addOneRow(TreeNode root, int val, int depth) {
    if (depth == 1) {
      return new TreeNode(val, root, null);
    } else if (depth == 2) {
      root.left = new TreeNode(val, root.left, null);
      root.right = new TreeNode(val, null, root.right);
    } else {
      if (root.left != null) {
        addOneRow(root.left, val, depth - 1);
      }
      if (root.right != null) {
        addOneRow(root.right, val, depth - 1);
      }
    }
    return root;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      int val = sc.nextInt();
      int depth = sc.nextInt();
      levelOrderLineByLine(addOneRow(root, val, depth));
    }
  }
}
