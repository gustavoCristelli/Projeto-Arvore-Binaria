public class BinaryTree {

    private class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node node, int value) {
        if (node == null) return new Node(value);
        if (value < node.value) node.left = insertRecursive(node.left, value);
        else if (value > node.value) node.right = insertRecursive(node.right, value);
        return node;
    }

    public void remove(int value) {
        root = removeRecursive(root, value);
    }

    private Node removeRecursive(Node node, int value) {
        if (node == null) return null;

        if (value < node.value) node.left = removeRecursive(node.left, value);
        else if (value > node.value) node.right = removeRecursive(node.right, value);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            node.value = findMin(node.right);
            node.right = removeRecursive(node.right, node.value);
        }
        return node;
    }

    private int findMin(Node node) {
        while (node.left != null) node = node.left;
        return node.value;
    }

    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node node, int value) {
        if (node == null) return false;
        if (value == node.value) return true;
        return value < node.value ? searchRecursive(node.left, value) : searchRecursive(node.right, value);
    }

    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.value + " ");
            printInOrder(node.right);
        }
    }

    public void printPreOrder() {
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    public void printPostOrder() {
        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public int getNodeDegree(int value) {
        Node node = findNode(root, value);
        if (node == null) return -1;
        int degree = 0;
        if (node.left != null) degree++;
        if (node.right != null) degree++;
        return degree;
    }

    private Node findNode(Node node, int value) {
        if (node == null || node.value == value) return node;
        if (value < node.value) return findNode(node.left, value);
        return findNode(node.right, value);
    }

    public boolean isFull() {
        return isFull(root);
    }

    private boolean isFull(Node node) {
        if (node == null) return true;
        if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) return false;
        return isFull(node.left) && isFull(node.right);
    }

    public boolean isStrictlyBinary() {
        return isFull();
    }

    public boolean isComplete() {
        if (root == null) return true;

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        boolean flag = false;

        while (!queue.isEmpty()) {
            Node current = queue.remove();

            if (current.left != null) {
                if (flag) return false;
                queue.add(current.left);
            } else {
                flag = true;
            }

            if (current.right != null) {
                if (flag) return false;
                queue.add(current.right);
            } else {
                flag = true;
            }
        }

        return true;
    }
} 