// Leetcode: 617. Merge Two Binary Trees

package myPackage.j15Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MergeBinaryTrees {

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

  static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return null;
    }
    if (root1 == null) {
      return root2;
    }
    if (root2 == null) {
      return root1;
    }
    root1.val += root2.val;
    root1.left = mergeTrees(root1.left, root2.left);
    root1.right = mergeTrees(root1.right, root2.right);
    return root1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str1 = sc.nextLine();
      TreeNode root1 = buildTree(str1);
      String str2 = sc.nextLine();
      TreeNode root2 = buildTree(str2);
      root1 = mergeTrees(root1, root2);
      System.out.println(levelOrderTraversal(root1, new ArrayList<>()));
    }
  }
}
