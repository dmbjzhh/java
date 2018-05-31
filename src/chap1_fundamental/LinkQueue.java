package chap1_fundamental;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkQueue<T> implements Iterable<T> {
	private Node first;
	private Node last;
	private int N;
	private class Node
	{
		T item;
		Node next;
	}
	public boolean isEmpty() {	return first == null;	}
	public int size() {	return N;	}
	public void enqueue(T item)
	{
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else {	oldlast.next = last;	}
		N++;
	}
	public T dequeue()
	{
		T item = first.item;
		first = first.next;
		if(isEmpty()) last = null;
		N--;
		return item;
	}
	public Iterator<T> iterator()
	{	return new ListIterator();	}
	private class ListIterator implements Iterator<T>
	{
		private Node current = first;
		public boolean hasNext() {	return current != null;	}
		public void remove() { }
		public T next()
		{
			T item = current.item;
			current = current.next;
			return item;
		}
	}
	public static void main(String[] args)
	{
		LinkQueue<String> s = new LinkQueue<String> ();
		while (!StdIn.isEmpty())
		{
			String i = StdIn.readString();
			s.enqueue(i);
		}
		
		for(String i:s)
			StdOut.println(i);
	}
}
