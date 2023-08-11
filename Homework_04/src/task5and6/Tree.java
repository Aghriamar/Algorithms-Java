package task5and6;

public class Tree<V extends Comparable<V>> {
    private Node root;
    private class Node{
        private V value;
        private Node left;
        private Node right;
        private boolean isRed;
        public Node(V value, boolean isRed){
            this.value = value;
            this.isRed = isRed;
        }
    }

    public boolean contains(V value){
        Node node = root;
        while (node != null){
            if(node.value.equals(value)){
                return true;
            }
            if(node.value.compareTo(value) > 0) {
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return false;
    }

    public void insert(V value) {
        root = insert(root, value);
        root.isRed = false;
    }

    private Node insert(Node node, V value) {
        if (node == null) {
            return new Node(value, true); // New nodes are always red
        }

        if (value.compareTo(node.value) < 0) {
            node.left = insert(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = insert(node.right, value);
        }

        // Balance the tree after insertion
        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.isRed;
    }

    private Node rotateLeft(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        newRoot.isRed = node.isRed;
        node.isRed = true;
        return newRoot;
    }

    private Node rotateRight(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        newRoot.isRed = node.isRed;
        node.isRed = true;
        return newRoot;
    }

    private void flipColors(Node node) {
        node.isRed = true;
        node.left.isRed = false;
        node.right.isRed = false;
    }

    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.value + (node.isRed ? " (R)" : " (B)"));
            if (node.left != null || node.right != null) {
                printTree(node.left, prefix + (isTail ? "    " : "│   "), false);
                printTree(node.right, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

    //реализация рекурсией
    public boolean containsRec(V value){
        if(root == null){
            return false;
        }
        return containsRec(root, value);
    }

    private boolean containsRec(Node node, V value) {
        if (node.value.equals(value)) {
            return true;
        } else {
            if (node.value.compareTo(value) > 0) {
                return containsRec(node.left, value);
            } else {
                return containsRec(node.right, value);
            }
        }
    }
}
