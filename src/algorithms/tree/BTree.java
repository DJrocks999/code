package algorithms.tree;

public class BTree {

    BTree(int value) {
        this.value = value;
    }

    int value;
    BTree left;
    BTree right;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        print(this, builder);
        return "BTREE :: " + builder.toString();
    }

    // inorder
    private void print(BTree tree, StringBuilder builder) {
        if (tree == null) {
            return;
        }
        print(tree.left, builder);
        builder.append(tree.value + " ");
        print(tree.right, builder);
    }
}
