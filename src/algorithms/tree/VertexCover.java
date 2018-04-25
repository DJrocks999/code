package algorithms.tree;

public class VertexCover {

    static int vCover(BTree root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }

        int inclusive = 1 + vCover(root.left) + vCover(root.right);
        int exclusive = 0;

        if (root.left != null) {
            exclusive += 1 + vCover(root.left.left) + vCover(root.left.right);
        }
        if (root.right != null) {
            exclusive += 1 + vCover(root.right.left) + vCover(root.right.right);
        }

        return Math.min(inclusive, exclusive);
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

        System.out.println(vCover(root));
    }
}
