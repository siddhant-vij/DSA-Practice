package myPackage.j15Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsHeightBalancedTree {

  static class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
      this.val = val;
    }
  }

  static Node buildTree(String str) {
    if (str.length() == 0 || str.charAt(0) == 'N') {
      return null;
    }
    String ip[] = str.split(" ");
    Node root = new Node(Integer.parseInt(ip[0]));
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    int i = 1;
    while (queue.size() > 0 && i < ip.length) {
      Node currNode = queue.peek();
      queue.remove();
      String currVal = ip[i];
      if (!currVal.equals("N")) {
        currNode.left = new Node(Integer.parseInt(currVal));
        queue.add(currNode.left);
      }
      i++;
      if (i >= ip.length)
        break;
      currVal = ip[i];
      if (!currVal.equals("N")) {
        currNode.right = new Node(Integer.parseInt(currVal));
        queue.add(currNode.right);
      }
      i++;
    }
    return root;
  }

  static int height(Node root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(height(root.left), height(root.right));
  }

  static boolean isBalancedI(Node root) {
    if (root == null) {
      return true;
    }
    return (Math.abs(height(root.left) - height(root.right)) <= 1) && isBalancedI(root.left) && isBalancedI(root.right);
  }

  static int isBalancedII(Node root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = isBalancedII(root.left);
    if (leftHeight == -1)
      return -1;

    int rightHeight = isBalancedII(root.right);
    if (rightHeight == -1)
      return -1;

    if (Math.abs(leftHeight - rightHeight) > 1)
      return -1;
    else
      return Math.max(leftHeight, rightHeight) + 1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      Node root = buildTree(str);
      System.out.println(isBalancedI(root));
      System.out.println(isBalancedII(root) == -1 ? false : true);
    }
  }
}
