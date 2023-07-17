// Leetcode: 662. Maximum Width of Binary Tree

package myPackage.j15Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxWidthCompleteBinaryTree {

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

  static class Pair {
    TreeNode node;
    int index;

    Pair(TreeNode node, int index) {
      this.node = node;
      this.index = index;
    }
  }

  static int widthOfBinaryTree(TreeNode root) {
    Queue<Pair> q = new LinkedList<>();
    q.offer(new Pair(root, 0));
    int maxWidth = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      int minIdx = q.peek().index;
      int firstNodeIdx = 0, lastNodeIdx = 0;
      for (int i = 0; i < size; i++) {
        int currIdx = q.peek().index - minIdx;
        TreeNode currNode = q.poll().node;
        if (i == 0)
          firstNodeIdx = currIdx;
        if (i == size - 1)
          lastNodeIdx = currIdx;
        if (currNode.left != null) {
          q.offer(new Pair(currNode.left, 2 * currIdx + 1));
        }
        if (currNode.right != null) {
          q.offer(new Pair(currNode.right, 2 * currIdx + 2));
        }
      }
      maxWidth = Math.max(maxWidth, lastNodeIdx - firstNodeIdx + 1);
    }
    return maxWidth;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      System.out.println(widthOfBinaryTree(root));
    }
  }  
}
