package test;

public class Node<E> {
    E element;
    Node<E> parent;
    Node<E> left;
    Node<E> right;

    public Node(E e, Node<E> parent, Object o, Object o1) {
        this.element = e;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }
}
