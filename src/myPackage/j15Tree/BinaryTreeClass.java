// Binary Tree is defined as a tree data structure where each node has at most 2 children. Since each element in a binary tree can have only 2 children, we typically name them the left and right child.

// Tree terms in detail:
// Root: The root of a tree is the topmost node of the tree that has no parent node. There is only one root node in every tree.
// Parent Node:  The node which is a predecessor of a node is called the parent node of that node.
// Child Node: The node which is the immediate successor of a node is called the child node of that node.
// Sibling: Children of the same parent node are called siblings.
// Edge: Edge acts as a link between the parent node and the child node.
// Leaf: A node that has no child is known as the leaf node. It is the last node of the tree. There can be multiple leaf nodes in a tree.
// Subtree: The subtree of a node is the tree considering that particular node as the root node.
// Depth: The depth of the node is the distance from the root node to that particular node.
// Height: The height of the node is the distance from that node to the deepest node of that subtree.
// Height of tree: The Height of the tree is the maximum height of any node. This is the same as the height of the root node.
// Level: A level is the number of parent nodes corresponding to a given node of the tree.
// Degree of node:  The degree of a node is the number of its children.
// NULL: The number of NULL nodes in a binary tree is (N+1), where N is the number of nodes in a binary tree.

// Properties of Binary Tree
// 1. The maximum number of nodes at level ‘l’ of a binary tree is 2^l.
// 2. The Maximum number of nodes in a binary tree of height ‘h’(height of the root is considered as 1) is 2^(h) – 1.
// 3. In a Binary Tree with N nodes, the minimum possible height or the minimum number of levels is Log2(N+1).
// 4. A Binary Tree with L leaves has at least |Log2L|+ 1 levels.
// 5. In a Binary tree where every node has 0 or 2 children, number of leaf nodes is always one more than nodes with two children.
// 6. In a non-empty binary tree, if n is the total number of nodes and e is the total number of edges, then e = n-1:


package myPackage.j15Tree;

class Node {
  int val;
  Node left;
  Node right;

  Node(int val) {
    this.val = val;
  }
}

public class BinaryTreeClass {
  public static void main(String[] args) {
    // Dynamic Node Representation (Linked Representation)
    Node root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
  }
}
