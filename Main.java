public class Main {

  public static void main(String[] args) {

    AvlTree tree = new AvlTree();

    int[] valuesToAdd = {1, 2, 3, 4, 5, 6, 7};

    for (int value : valuesToAdd) {
      tree.add(value);
      System.out.println("After adding " + value + ":");
      System.out.println(tree.toString());
    }

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
