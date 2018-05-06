package algorithms.tree;

public class BTreeToDLL {

    static DLL HEAD = null;
    static DLL TAIL = null;

    static BTree dllToBST(DLL head) {
        if (head == null) {
            return null;
        }

        DLL first = head;
        DLL second = head.next;

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }

        BTree root = new BTree(first.value);

        //break the link
        if (first.prev != null) {
            first.prev.next = null;
        }
        first.prev = null;
        DLL next = first.next;
        first.next = null;
        if (first == head) {
            head = null;
        }

        root.left = dllToBST(head);
        root.right = dllToBST(next);

        return root;
    }

    static void bstToDLL(BTree root) {
        if (root == null) {
            return;
        }

        bstToDLL(root.left);
        DLL dll = new DLL(root.value);
        if (TAIL == null) {
            TAIL = dll;
            HEAD = dll;
        } else {
            TAIL.next = dll;
            TAIL.next.prev = TAIL;
            TAIL = dll;
        }
        bstToDLL(root.right);
    }


    public static void main(String[] args) {
        DLL head = new DLL(1);
        DLL first = new DLL(2);
        DLL second = new DLL(3);
        DLL third = new DLL(4);
        DLL forth = new DLL(5);
        DLL fifth = new DLL(6);
        DLL sixth = new DLL(7);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;

        sixth.prev = fifth;
        fifth.prev = forth;
        forth.prev = third;
        third.prev = second;
        second.prev = first;
        first.prev = head;

        BTree bTree = dllToBST(head);
        System.out.println(bTree);

        bstToDLL(bTree);
        System.out.println(HEAD);
    }
}
