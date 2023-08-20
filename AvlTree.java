public class AvlTree {

  Node root;

  public AvlTree add(int value) {
    root = add(root, value);
    return this;
  }

  public boolean contains(int value) {
    return contains(root, value);
  }

  private boolean contains(Node node, int value) {
    if (node == null) {
      return false;
    }
    if (value < node.value) {
      return contains(node.left, value);
    } else if (value > node.value) {
      return contains(node.right, value);
    } else {
      return true;
    }
  }

  private int getHeight(Node node) {
    if (node == null) {
      return 0;
    }
    return node.height;
  }

  private int getBalance(Node node) {
    if (node == null) {
      return 0;
    }
    return getHeight(node.left) - getHeight(node.right);
  }

  private Node rotateRight(Node node) {
    Node leftNode = node.left;
    Node middle = leftNode.right;

    leftNode.right = node;
    node.left = middle;

    node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    leftNode.height = Math.max(getHeight(leftNode.left), getHeight(leftNode.right)) + 1;

    return leftNode;
  }

  private Node rotateLeft(Node node) {
    Node rightNode = node.right;
    Node middle = rightNode.left;

    rightNode.left = node;
    node.right = middle;

    node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    rightNode.height = Math.max(getHeight(rightNode.left), getHeight(rightNode.right)) + 1;

    return rightNode;
  }
}
