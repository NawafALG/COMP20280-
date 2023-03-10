package test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class LinkedBinaryTree<E> {

    public Node<E> root;
    private int size;

    public void constructRandom(int n) {
        if (!isEmpty()) return;
        AtomicInteger key = new AtomicInteger(0);
        root = randomTree(null, n, key);
    }

    private boolean isEmpty() {
        return root == null;
    }

    private Node<E> randomTree(Node<E> parent, Integer n, AtomicInteger key) {
        if (n == 0) return null;
        Random rnd = new Random();
        Integer leftCount = rnd.nextInt(n); // split the number of nodes
        Node<E> node = new Node<E>((E) ((Integer) key.get()), parent, null, null);
        size++;
        key.getAndIncrement();
        node.left = randomTree(node, leftCount, key);
        key.getAndIncrement();
        node.right = randomTree(node, n - leftCount - 1, key);
        return node;
    }

    public int findHeight(Node<E> root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int findDiameter(Node<E> root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        int leftDiameter = findDiameter(root.left);
        int rightDiameter = findDiameter(root.right);

        return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
    }

    public String toBinaryTreeString() {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            toBinaryTreeString(root, 1, sb);
        }
        return sb.toString();
    }

    private void toBinaryTreeString(Node<E> node, int level, StringBuilder sb) {
        if (node == null) {
            return;
        }

        toBinaryTreeString(node.right, level + 1, sb);

        for (int i = 1; i < level; i++) {
            sb.append("    ");
        }
        sb.append(node.element);
        sb.append("\n");

        toBinaryTreeString(node.left, level + 1, sb);
    }


}
