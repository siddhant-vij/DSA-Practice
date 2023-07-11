// Leetcode: 2096. Step-By-Step Directions From a Binary Tree Node to Another

package myPackage.j15Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class DirectionNodeTraversal {

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

  static int index = -1;

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

  static TreeNode lca(TreeNode root, int n1, int n2, List<TreeNode> path1, List<TreeNode> path2) {
    if (!findPath(root, path1, n1) || !findPath(root, path2, n2)) {
      return null;
    }
    int i;
    for (i = 0; i < path1.size() - 1 && i < path2.size() - 1; i++) {
      if (path1.get(i + 1) != path2.get(i + 1)) {
        index = i;
        return path1.get(i);
      }
    }
    if (path1.get(i) == path2.get(i)) {
      index = i;
      return path1.get(i);
    }
    return null;
  }

  static List<Integer> nodesToInteger(List<TreeNode> path) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < path.size(); i++) {
      list.add(path.get(i).val);
    }
    return list;
  }

  static String getDirections(TreeNode root, int s, int t) {
    List<TreeNode> path1 = new ArrayList<>();
    List<TreeNode> path2 = new ArrayList<>();
    TreeNode lca = lca(root, s, t, path1, path2);

    List<Integer> list1 = nodesToInteger(path1);
    List<Integer> list2 = nodesToInteger(path2);
    int countU = list1.size() - 1 - index;
    int ptr = index + 1;
    TreeNode cur = lca;
    StringBuilder strB = new StringBuilder();
    while (ptr != list2.size()) {
      if (cur.left != null && cur.left.val == list2.get(ptr)) {
        strB.append("L");
        cur = cur.left;
      } else if (cur.right != null && cur.right.val == list2.get(ptr)) {
        strB.append("R");
        cur = cur.right;
      }
      ptr++;
    }
    for (int i = 0; i < countU; i++) {
      strB.insert(0, "U");
    }
    return strB.toString();
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      int s = sc.nextInt();
      int t = sc.nextInt();
      System.out.println(getDirections(root, s, t));
    }
  }
}
