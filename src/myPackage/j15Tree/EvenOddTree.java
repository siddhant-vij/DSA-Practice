// Leetcode: 1609. Even Odd Tree

package myPackage.j15Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EvenOddTree {

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

  static boolean isEvenOddTree(TreeNode root) {
    if (root == null) {
      return false;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    int level = 0;
    while (queue.size() > 1) {
      TreeNode cur = queue.remove();
      if (cur == null) {
        queue.add(null);
        level++;
        continue;
      }
      if (level % 2 == 0) {
        if (cur.val % 2 != 0) {
          if (queue.peek() != null && queue.peek().val <= cur.val) {
            return false;
          }
        } else {
          return false;
        }
      } else {
        if (cur.val % 2 == 0) {
          if (queue.peek() != null && queue.peek().val >= cur.val) {
            return false;
          }
        } else {
          return false;
        }
      }
      if (cur.left != null)
        queue.add(cur.left);
      if (cur.right != null)
        queue.add(cur.right);
    }
    return true;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      System.out.println(isEvenOddTree(root));
    }
  }
}
