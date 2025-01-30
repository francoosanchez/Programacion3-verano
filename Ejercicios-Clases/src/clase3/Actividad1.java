package clase3;

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Método para insertar un nuevo nodo en el árbol
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Método para obtener la altura del árbol
    public int getHeight() {
        return getHeightRec(root);
    }

    private int getHeightRec(Node node) {
        // Caso base: si el nodo es null, la altura es -1
        if (node == null) {
            return -1;
        }

        // Llamada recursiva para obtener la altura de los subárboles izquierdo y derecho
        int leftHeight = getHeightRec(node.left);
        int rightHeight = getHeightRec(node.right);

        // La altura del nodo actual es el máximo entre las alturas de los subárboles más 1
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Método para mostrar el árbol (inorden) para verificar la inserción
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }
}

public class Actividad1 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insertar nodos en el árbol
        bst.insert(10);
        bst.insert(5);
        bst.insert(20);
        bst.insert(3);
        bst.insert(7);

        // Mostrar el árbol en orden
        System.out.print("Árbol en orden: ");
        bst.inorder();
        System.out.println();

        // Obtener y mostrar la altura del árbol
        int height = bst.getHeight();
        System.out.println("La altura del árbol es: " + height);
    }


}
