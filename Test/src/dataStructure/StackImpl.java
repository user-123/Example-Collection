package dataStructure;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class StackImpl<T> {	//<T extends Object>
	private T[] array;
	private int indexPointer;

	public StackImpl() {
		this(16);
	}

	public StackImpl(int size) {
		if(size<=0) {
			throw new IllegalArgumentException("Size must be greater than zero.");
		}
		this.array = (T[]) Array.newInstance(getClass(), size);	//(T[]) new Object[size];
		this.indexPointer = 0;
	}

	public boolean push(T element) {
		if(indexPointer>=array.length-1) {
			System.err.println("Stack is full.");
			return false;
		}
		array[indexPointer++] = element;
		return true;
	}

	public T pop() {
		if(indexPointer<=0) {
			throw new NoSuchElementException("Stack is empty.");
		}
		return array[--indexPointer];
	}

	public static void main(String[] args) {}

}
