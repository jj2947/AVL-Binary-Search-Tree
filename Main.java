public class Main {

  public static void main(String[] args) {

    AvlTree tree = new AvlTree();
    int n = 1000000;
    for (int i = 0; i < n; i++) {
      tree.add(i);
      tree.add(-i);
    }
    for (int i = 0; i < n; i++) {
      tree.contains(n - 1);
      tree.contains(-n + 1);
    }
  }
}
