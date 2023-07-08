// Leetcode: 257. Binary Tree Paths

package myPackage.j15Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreePaths {

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
    if (root == null)
      return;
    list.add(root.val);
    if (root.left == null && root.right == null) {
      result.add(new ArrayList<>(list));
    }
    dfs(root.left, list);
    dfs(root.right, list);
    list.remove(list.size() - 1);
  }

  static List<String> binaryTreePaths(TreeNode root) {
    dfs(root, new ArrayList<>());
    List<String> output = new ArrayList<>();
    for (int i = 0; i < result.size(); i++) {
      List<Integer> list = result.get(i);
      StringBuilder strB = new StringBuilder();
      for (int j = 0; j < list.size(); j++) {
        if (j == 0)
          strB.append(list.get(j));
        else {
          strB.append("->");
          strB.append(list.get(j));
        }
      }
      output.add(strB.toString());
    }
    return output;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      System.out.println(binaryTreePaths(root));
    }
  }
}
