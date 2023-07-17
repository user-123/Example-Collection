package dataStructure;

import java.util.NoSuchElementException;

public class QueueImpl<E extends Object> {
	private E[] array;
	private int beginPointer;
	private int endPointer;
	private int size;

	public QueueImpl() {
		this(16);
	}

	public QueueImpl(int size) {
		this.array = (E[]) new Object[size];	//????????????
		this.beginPointer = 0;
		this.endPointer = 0;
		this.size = 0;
	}

	public boolean offer(E element) {
		if(size>=array.length) {
			System.err.println("Queue is full.");
			return false;
		}
		array[endPointer++] = element;
		if(endPointer>=array.length) {endPointer=0;}
		size++;
		return true;
	}

	public E poll() {
		if(size<=0) {
			throw new NoSuchElementException("Stack is empty.");
		}
		E element = array[beginPointer++];
		if(beginPointer>=array.length) {beginPointer=0;}
		size--;
		return element;
	}

	public static void main(String[] args) {}

}
