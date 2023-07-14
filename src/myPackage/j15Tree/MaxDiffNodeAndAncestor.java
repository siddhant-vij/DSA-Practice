// Leetcode: 1026. Maximum Difference Between Node and Ancestor

package myPackage.j15Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MaxDiffNodeAndAncestor {

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

  static List<List<Integer>> result = new ArrayList<>();

  static void dfs(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    list.add(root.val);
    if (root.left == null && root.right == null) {
      result.add(new ArrayList<>(list));
    }
    dfs(root.left, list);
    dfs(root.right, list);
    list.remove(list.size() - 1);
  }

  static int maxAncestorDiffI(TreeNode root) {
    dfs(root, new ArrayList<>());
    int maxDiff = Integer.MIN_VALUE;
    for (int i = 0; i < result.size(); i++) {
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < result.get(i).size(); j++) {
        min = Math.min(min, result.get(i).get(j));
        max = Math.max(max, result.get(i).get(j));
      }
      maxDiff = Math.max(maxDiff, Math.abs(max - min));
    }
    return maxDiff;
  }

  static int helper(TreeNode node, int curMax, int curMin) {
    if (node == null) {
      return curMax - curMin;
    }
    curMax = Math.max(curMax, node.val);
    curMin = Math.min(curMin, node.val);
    return Math.max(helper(node.left, curMax, curMin), helper(node.right, curMax, curMin));
  }

  static int maxAncestorDiffII(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return helper(root, root.val, root.val);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      System.out.println(maxAncestorDiffI(root));
      System.out.println(maxAncestorDiffII(root));
    }
  }
}
