// Leetcode: 1123. Lowest Common Ancestor of Deepest Leaves
// Leetcode: 865. Smallest Subtree with all the Deepest Nodes

package myPackage.j15Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class LCAofDeppestLeaves {

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

  static Set<TreeNode> set = new HashSet<>();

  static void levelOrderLineByLine(TreeNode root) {
    if (root == null)
      return;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    while (queue.size() > 1) {
      TreeNode cur = queue.remove();
      if (cur == null) {
        queue.add(null);
        set = new HashSet<>();
        continue;
      }
      set.add(cur);
      if (cur.left != null)
        queue.add(cur.left);
      if (cur.right != null)
        queue.add(cur.right);
    }
  }

  static TreeNode lca(TreeNode root, int n1, int n2) {
    if (root == null)
      return null;
    if (root.val == n1 || root.val == n2)
      return root;
    TreeNode lca1 = lca(root.left, n1, n2);
    TreeNode lca2 = lca(root.right, n1, n2);
    if (lca1 != null && lca2 != null)
      return root;
    if (lca1 != null)
      return lca1;
    else
      return lca2;
  }

  static TreeNode lcaDeepestLeaves(TreeNode root) {
    levelOrderLineByLine(root);
    if (set.size() == 1) {
      return set.toArray(new TreeNode[set.size()])[0];
    }
    TreeNode[] nodes = set.toArray(new TreeNode[set.size()]);
    TreeNode lca = nodes[0];
    for (int i = 1; i < nodes.length; i++)
      lca = lca(root, lca.val, nodes[i].val);
    return lca;
  }

  static String serialize(TreeNode root) {
    if (root == null) {
      return null;
    }
    Stack<TreeNode> s = new Stack<>();
    s.push(root);

    List<String> l = new ArrayList<>();
    while (!s.isEmpty()) {
      TreeNode t = s.pop();
      if (t != null) {
        l.add("" + t.val);
        s.push(t.right);
        s.push(t.left);
      }
    }
    return String.join(",", l);
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      TreeNode root = buildTree(str);
      System.out.println(serialize(lcaDeepestLeaves(root)));
    }
  }
}
