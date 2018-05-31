package chap1_fundamental;

import java.util.*;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class Bag<T> implements Iterable<T>
{
	private Node first;
	private class Node
	{
		T item;
		Node next;
	}
	public void add(T item)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	public int size()
	{
		Node cur = first;
		int count = 0;
		while(cur != null)
		{
			count += 1;
			cur = cur.next;
		}
		return count;
	}
	public Iterator<T> iterator()
	{	return new ListIterator();	}
	private class ListIterator implements Iterator<T>
	{
		private Node current = first;
		public boolean hasNext()
		{	return current != null;	}
		public void remove()	{ }
		public T next()
		{
			T item = current.item;
			current = current.next;
			return item;
		}
	}
	public static void main(String[] args)
	{
		Bag<Double> numbers = new Bag<Double>();
		System.out.println("please enter some numbers: ");
		while (!StdIn.isEmpty())
			numbers.add(StdIn.readDouble());
		int N = numbers.size();
		double sum = 0.0;
		for (double x: numbers)
			sum += x;
		double mean = sum/N;
		sum = 0.0;
		for (double x: numbers)
			sum += (x-mean)*(x-mean);
		double std = Math.sqrt(sum/(N-1));
		StdOut.printf("Mean: %.2f\n", mean);
		StdOut.printf("Std dev: %.2f\n", std);
		
	}
}
