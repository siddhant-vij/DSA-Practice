// Leetcode: 2415. Reverse Odd Levels of Binary Tree

package myPackage.j15Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ReverseOddLevels {

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

  static List<Integer> levelOrderTraversal(TreeNode root, List<Integer> result) {
    if (root == null)
      return result;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode curNode = queue.remove();
      result.add(curNode.val);
      if (curNode.left != null)
        queue.add(curNode.left);
      if (curNode.right != null)
        queue.add(curNode.right);
    }
    return result;
  }

  static void reverse(TreeNode root1, TreeNode root2, int level) {
    if ((root1.left == root1.right) || (root2.left == root2.right))
      return;
    if (level % 2 == 0) {
      int temp = root1.left.val;
      root1.left.val = root2.right.val;
      root2.right.val = temp;
    }
    reverse(root1.left, root2.right, level + 1);
    reverse(root1.right, root2.left, level + 1);
  }

  static TreeNode reverseOddLevels(TreeNode root) {
    reverse(root, root, 0);
    return root;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      root = reverseOddLevels(root);
      System.out.println(levelOrderTraversal(root, new ArrayList<>()));
    }
  }  
}
