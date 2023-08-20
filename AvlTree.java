public class AvlTree {

  Node root;

  private int getHeight(Node node) {
    if (node == null) {
      return 0;
    }
    return node.height;
  }

  private int getBalance(Node node) {
    if (node == null) return 0;
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
}
