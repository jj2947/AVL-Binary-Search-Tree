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

  private Node add(Node node, int value) {
    if (node == null) {
      return new Node(value);
    }

    if (value < node.value) {
      node.left = add(node.left, value);
    } else if (value > node.value) {
      node.right = add(node.right, value);
    } else {
      return node;
    }

    node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

    return rotate(node, value);
  }

  private Node rotate(Node node, int value) {
    int balance = getBalance(node);

    // Left-Left case
    if (balance > 1 && value < node.left.value) {
      return rotateRight(node);
    }

    // Right-Right case
    if (balance < -1 && value > node.right.value) {
      return rotateLeft(node);
    }

    // Left-Right case
    if (balance > 1 && value > node.left.value) {
      node.left = rotateLeft(node.left);
      return rotateRight(node);
    }

    // Right-Left case
    if (balance < -1 && value < node.right.value) {
      node.right = rotateRight(node.right);
      return rotateLeft(node);
    }

    return node;
  }

  public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb, Node node) {
    if (node.right != null) {
      toString(
          new StringBuilder().append(prefix).append(isTail ? "│   " : "    "),
          false,
          sb,
          node.right);
    }
    sb.append(prefix).append(isTail ? "└── " : "┌── ").append(node.value).append("\n");
    if (node.left != null) {
      toString(
          new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb, node.left);
    }
    return sb;
  }

  @Override
  public String toString() {
    return this.toString(new StringBuilder(), true, new StringBuilder(), root).toString();
  }
}
