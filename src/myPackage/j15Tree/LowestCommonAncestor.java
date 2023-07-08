// Practice: LCA (Lowest Common Ancestor) of Binary Tree

package myPackage.j15Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class LowestCommonAncestor {

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

  static boolean findPath(TreeNode root, List<TreeNode> path, int n) {
    if (root == null) {
      return false;
    }
    path.add(root);
    if (root.val == n) {
      return true;
    }
    if (findPath(root.left, path, n) || findPath(root.right, path, n)) {
      return true;
    }
    path.remove(path.size() - 1);
    return false;
  }

  static TreeNode lcaI(TreeNode root, int n1, int n2) {
    List<TreeNode> path1 = new ArrayList<>();
    List<TreeNode> path2 = new ArrayList<>();
    if (!findPath(root, path1, n1) || !findPath(root, path2, n2)) {
      return null;
    }
    int i;
    for (i = 0; i < path1.size() - 1 && i < path2.size() - 1; i++) {
      if (path1.get(i + 1) != path2.get(i + 1))
        return path1.get(i);
    }
    if (path1.get(i) == path2.get(i))
      return path1.get(i);
    return null;
  }

  static TreeNode lcaII(TreeNode root, int n1, int n2) {
    if (root == null)
      return null;
    if (root.val == n1 || root.val == n2)
      return root;
    TreeNode lca1 = lcaII(root.left, n1, n2);
    TreeNode lca2 = lcaII(root.right, n1, n2);
    if (lca1 != null && lca2 != null)
      return root;
    if (lca1 != null)
      return lca1;
    else
      return lca2;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      int n1 = sc.nextInt();
      int n2 = sc.nextInt();
      TreeNode result1 = lcaI(root, n1, n2);
      TreeNode result2 = lcaII(root, n1, n2); // Assumption: Both n1 & n2 present in Tree
      System.out.println(result1 != null ? result1.val : Integer.MIN_VALUE);
      System.out.println(result2.val);
    }
  }
}
