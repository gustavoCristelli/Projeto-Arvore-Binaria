class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("In-ordem:");
        tree.printInOrder();

        System.out.println("Pré-ordem:");
        tree.printPreOrder();

        System.out.println("Pós-ordem:");
        tree.printPostOrder();

        System.out.println("Altura da árvore: " + tree.getHeight());
        System.out.println("Grau do nó 30: " + tree.getNodeDegree(30));
        System.out.println("Busca 60: " + tree.search(60));
        System.out.println("Árvore cheia: " + tree.isFull());
        System.out.println("Árvore estritamente binária: " + tree.isStrictlyBinary());
        System.out.println("Árvore completa: " + tree.isComplete());

        tree.remove(30);
        System.out.println("In-ordem após remoção:");
        tree.printInOrder();
    }
}
