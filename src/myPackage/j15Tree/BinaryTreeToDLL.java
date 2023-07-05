package myPackage.j15Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeToDLL {

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

  static Node head = null;
  static Node prev = null;

  static Node convert(Node root) {
    if (root == null) {
      return root;
    }
    convert(root.left);
    Node cur = root;
    if (prev == null) {
      head = cur;
    } else {
      prev.right = cur;
      cur.left = prev;
    }
    prev = cur;
    convert(root.right);
    return head;
  }

  static void printList(Node head) {
    Node curNode = head;
    while (curNode != null) {
      System.out.print(curNode.val + " ");
      curNode = curNode.right;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.nextLine();
      Node root = buildTree(str);
      printList(convert(root));
    }
  }
}
