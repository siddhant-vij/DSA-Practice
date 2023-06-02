// Practice: Polynomial Arithmetic
// 1. Creation of Sorted SLL (based on polynomial exponent)
// 2. Addition
// 3. Subtraction
// 4. Multiplication

package myPackage.j11LinkedList;

import java.util.Scanner;

public class PolynomialArithmetic {

  Node head;
  Node tail;

  class Node {
    int coef;
    int expo;
    Node next;

    Node(int coef, int expo) {
      this.coef = coef;
      this.expo = expo;
    }
  }

  void printPolynomial() {
    if (head == null) {
      System.out.println("No polynomial");
      return;
    }
    Node cur = head;
    while (cur != tail) {
      System.out.print("(" + cur.coef + ")x^" + cur.expo + " + ");
      cur = cur.next;
    }
    System.out.println("(" + tail.coef + ")x^" + tail.expo);
  }

  void insertAtEmpty(int coef, int expo) {
    Node newNode = new Node(coef, expo);
    head = newNode;
    tail = head;
  }

  void insertAtStart(int coef, int expo) {
    Node newNode = new Node(coef, expo);
    newNode.next = head;
    head = newNode;
  }

  void insertAtEnd(int coef, int expo) {
    Node newNode = new Node(coef, expo);
    tail.next = newNode;
    tail = newNode;
  }

  void insertNode(int coef, int expo) {
    if (head == null) {
      insertAtEmpty(coef, expo);
      return;
    } else if (head.expo < expo) {
      insertAtStart(coef, expo);
      return;
    } else if (tail.expo > expo) {
      insertAtEnd(coef, expo);
      return;
    }
    Node cur = head;
    while (cur != null) {
      if (cur.expo == expo) {
        cur.coef += coef;
        return;
      } else if (cur.next != null && !(cur.expo > expo && cur.next.expo < expo))
        cur = cur.next;
      else
        break;
    }
    Node newNode = new Node(coef, expo);
    newNode.next = cur.next;
    cur.next = newNode;
  }

  void additionPolynomials(Node h1, Node h2) {
    if (h1 == null && h2 == null) {
      System.out.println("Both Empty Polynomials");
      return;
    }
    Node cur1 = h1;
    Node cur2 = h2;
    while (cur1 != null || cur2 != null) {
      if (cur1 == null && cur2 != null) {
        insertNode(cur2.coef, cur2.expo);
        cur2 = cur2.next;
      } else if (cur1 != null && cur2 == null) {
        insertNode(cur1.coef, cur1.expo);
        cur1 = cur1.next;
      } else {
        if (cur1.expo > cur2.expo) {
          insertNode(cur1.coef, cur1.expo);
          cur1 = cur1.next;
        } else if (cur1.expo < cur2.expo) {
          insertNode(cur2.coef, cur2.expo);
          cur2 = cur2.next;
        } else {
          insertNode(cur1.coef + cur2.coef, cur1.expo);
          cur1 = cur1.next;
          cur2 = cur2.next;
        }
      }
    }
  }

  void subtractionPolynomials(Node h1, Node h2) {
    if (h1 == null && h2 == null) {
      System.out.println("Both Empty Polynomials");
      return;
    }
    Node cur1 = h1;
    Node cur2 = h2;
    while (cur1 != null || cur2 != null) {
      if (cur1 == null && cur2 != null) {
        insertNode(0 - cur2.coef, cur2.expo);
        cur2 = cur2.next;
      } else if (cur1 != null && cur2 == null) {
        insertNode(cur1.coef, cur1.expo);
        cur1 = cur1.next;
      } else {
        if (cur1.expo > cur2.expo) {
          insertNode(cur1.coef, cur1.expo);
          cur1 = cur1.next;
        } else if (cur1.expo < cur2.expo) {
          insertNode(0 - cur2.coef, cur2.expo);
          cur2 = cur2.next;
        } else {
          insertNode(cur1.coef - cur2.coef, cur1.expo);
          cur1 = cur1.next;
          cur2 = cur2.next;
        }
      }
    }
  }

  void multiplicationPolynomials(Node h1, Node h2) {
    if (h1 == null || h2 == null) {
      System.out.println("One of them is Empty Polynomial");
      return;
    }
    Node cur1 = h1;
    while (cur1 != null) {
      Node cur2 = h2;
      while (cur2 != null) {
        insertNode(cur1.coef * cur2.coef, cur1.expo + cur2.expo);
        cur2 = cur2.next;
      }
      cur1 = cur1.next;
    }
  }

  public static void main(String args[]) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      PolynomialArithmetic obj1 = new PolynomialArithmetic();
      for (int i = 0; i < n; i++) {
        obj1.insertNode(sc.nextInt(), sc.nextInt());
      }
      obj1.printPolynomial();
      int m = sc.nextInt();
      PolynomialArithmetic obj2 = new PolynomialArithmetic();
      for (int i = 0; i < m; i++) {
        obj2.insertNode(sc.nextInt(), sc.nextInt());
      }
      obj2.printPolynomial();

      PolynomialArithmetic obj3 = new PolynomialArithmetic();
      obj3.additionPolynomials(obj1.head, obj2.head);
      obj3.printPolynomial();

      PolynomialArithmetic obj4 = new PolynomialArithmetic();
      obj4.subtractionPolynomials(obj1.head, obj2.head);
      obj4.printPolynomial();

      PolynomialArithmetic obj5 = new PolynomialArithmetic();
      obj5.multiplicationPolynomials(obj1.head, obj2.head);
      obj5.printPolynomial();
    }
  }
}
