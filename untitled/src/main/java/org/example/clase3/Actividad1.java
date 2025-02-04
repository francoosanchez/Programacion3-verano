package org.example.clase3;


public class Actividad1 {
    public TreeNode searchBST(TreeNode root, int x) {
        // Caso base: si el nodo es nulo o si el valor del nodo es el que estamos buscando
        if (root == null || root.value == x) {
            return root;
        }

        // Si el valor a buscar es menor que el valor del nodo actual, buscar en el subárbol izquierdo
        if (x < root.value) {
            return searchBST(root.left, x);
        }

        // Si el valor a buscar es mayor que el valor del nodo actual, buscar en el subárbol derecho
        return searchBST(root.right, x);
    }

    // Método para calcular la altura del árbol
    public static int getHeight(TreeNode node) {
        if (node == null) {
            return -1; // Altura de un árbol vacío
        }

        // Dividir: calcular altura de los subárboles izquierdo y derecho
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // Vencer y Combinar: seleccionar la altura máxima y sumar 1
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        // Crear un árbol de ejemplo
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);
        root.right.right.right = new TreeNode(30);

        // Obtener la altura del árbol
        System.out.println("Altura del BST: " + getHeight(root)); // Salida esperada: 3


    }

    public static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
            left = right = null;
        }
    }

}
