package dataStructure;
public class DoublyLinkedList<E> {
	private Node<E> node;
	private Node<E> first;
	private Node<E> last;
	private int size;

	// TODO





	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;

		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}

}
