package chap1_fundamental;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class LinkStack<T> implements Iterable<T>{
	private Node first;
	private int N;
	private class Node
	{
		T item;
		Node next;
	}
	public boolean isEmpty() {	return first == null;	}
	public int size() {	return N;	}
	public void push(T item)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public T pop()
	{
		T item = first.item;
		first = first.next;
		N--;
		return item;
	}
	public Iterator<T> iterator()
	{
		return new ListIterator();
	}
	private class ListIterator implements Iterator<T>
	{
		private Node current = first;
		public boolean hasNext() 
		{
			return current != null;
		}
		public void remove()
		{ }
		public T next()
		{
			T item = current.item;
			current = current.next;
			return item;
		}
	}
	public static void main(String[] args)
	{
		LinkStack<String> s;
		s = new LinkStack<String>();
		while (!StdIn.isEmpty())
		{
			String item = StdIn.readString();
			s.push(item);
		}
		for(String i:s)
			StdOut.println(i);
	}
}
