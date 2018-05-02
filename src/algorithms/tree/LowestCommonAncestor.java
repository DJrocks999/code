package algorithms.tree;

public class LowestCommonAncestor {

    static BTree LCA(BTree root, int a, int b) {
        if (root == null) {
            return null;
        }

        if (root.value == a || root.value == b) {
            return root;
        }

        BTree left = LCA(root.left, a, b);
        BTree right = LCA(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        BTree root = new BTree(10);
        BTree l1 = new BTree(20);
        BTree r1 = new BTree(30);
        BTree ll1 = new BTree(40);
        BTree lr1 = new BTree(50);
        BTree lrl1 = new BTree(70);
        BTree lrr1 = new BTree(80);
        BTree rr1 = new BTree(60);

        root.left = l1;
        root.right = r1;
        l1.left = ll1;
        l1.right = lr1;
        lr1.left = lrl1;
        lr1.right = lrr1;
        r1.right = rr1;

        System.out.println(LCA(root, 70, 80).value);
    }
}
