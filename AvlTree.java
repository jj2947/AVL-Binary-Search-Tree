public class AvlTree {

  Node root;

  int getHeight(Node node) {
    if (node == null){
        return 0;
    }
    return node.height;
  }
}
