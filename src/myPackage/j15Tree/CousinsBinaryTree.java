// Leetcode: 993. Cousins in Binary Tree

package myPackage.j15Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CousinsBinaryTree {

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

  static TreeNode getParent(TreeNode root, int n) {
    if (root == null)
      return null;
    if (root.left != null && root.left.val == n || root.right != null && root.right.val == n)
      return root;
    TreeNode res = getParent(root.left, n);
    if (res != null)
      return res;
    return getParent(root.right, n);
  }

  static int getDepth(TreeNode root, int x) {
    if (root == null)
      return 0;
    int depth = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    while (queue.size() > 1) {
      TreeNode cur = queue.remove();
      if (cur == null) {
        depth++;
        queue.add(null);
        continue;
      }
      if (cur.val == x)
        return depth;
      if (cur.left != null)
        queue.add(cur.left);
      if (cur.right != null)
        queue.add(cur.right);
    }
    return -1;
  }

  static boolean isCousins(TreeNode root, int x, int y) {
    if (root.val == x || root.val == y)
      return false;
    TreeNode parent1 = getParent(root, x);
    TreeNode parent2 = getParent(root, y);
    if (parent1 == parent2)
      return false;
    else {
      int depth1 = getDepth(root, x);
      int depth2 = getDepth(root, y);
      return depth1 == depth2;
    }
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      int s = sc.nextInt();
      int t = sc.nextInt();
      System.out.println(isCousins(root, s, t));
    }
  }  
}
