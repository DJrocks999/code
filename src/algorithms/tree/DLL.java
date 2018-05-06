package algorithms.tree;

public class DLL {

    public DLL(int value) {
        this.value = value;
    }

    int value;
    DLL prev;
    DLL next;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        print(this, builder);
        return "DLL :: " + builder.toString();
    }

    private void print(DLL dll, StringBuilder builder) {
        if (dll == null) {
            return;
        }

        while (true) {
            builder.append(dll.value);
            dll = dll.next;
            if (dll == null) {
                break;
            }
            builder.append(" <=> ");
        }
    }
}
