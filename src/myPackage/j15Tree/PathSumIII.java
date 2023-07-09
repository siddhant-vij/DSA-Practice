// Leetcode: 437. Path Sum III

package myPackage.j15Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class PathSumIII {

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

  static void dfs(TreeNode root, int target, long curSum) {
    if (root == null) {
      return;
    }
    curSum += 1L * root.val;
    if (curSum == target) {
      count++;
    }
    if (map.containsKey(curSum - target)) {
      count += map.get(curSum - target);
    }
    map.put(curSum, map.getOrDefault(curSum, 0) + 1);
    dfs(root.left, target, curSum);
    dfs(root.right, target, curSum);
    map.put(curSum, map.get(curSum) - 1);
  }

  static Map<Long, Integer> map = new HashMap<>();
  static int count = 0;

  static int pathSum(TreeNode root, int targetSum) {
    if (root == null)
      return 0;
    dfs(root, targetSum, 0);
    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      int k = sc.nextInt();
      System.out.println(pathSum(root, k));
    }
  }  
}
