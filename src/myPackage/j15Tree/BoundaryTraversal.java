// Practice: Boundary Traversal of Binary Tree

package myPackage.j15Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BoundaryTraversal {

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

  static ArrayList<Integer> result = new ArrayList<>();

  static void traverseLeft(Node root) {
    if (root == null || root.left == root.right) {
      return;
    }
    result.add(root.val);
    if (root.left != null)
      traverseLeft(root.left);
    else
      traverseLeft(root.right);
  }

  static void traverseLeaf(Node root) {
    if (root == null) {
      return;
    }
    if (root.left == root.right) {
      result.add(root.val);
      return;
    }
    traverseLeaf(root.left);
    traverseLeaf(root.right);
  }

  static void traverseRight(Node root) {
    if (root == null || root.left == root.right) {
      return;
    }
    if (root.right != null)
      traverseRight(root.right);
    else
      traverseRight(root.left);
    result.add(root.val);
  }

  static ArrayList<Integer> boundary(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }
    result.add(root.val);

    traverseLeft(root.left);

    traverseLeaf(root.left);
    traverseLeaf(root.right);

    traverseRight(root.right);
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      Node root = buildTree(str);
      System.out.println(boundary(root));
    }
  }
}
