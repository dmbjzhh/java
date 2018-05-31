package chap1_fundamental;
// 动态调整大小的可以迭代的栈
import edu.princeton.cs.algs4.*;
import java.util.Iterator;

public class DynamicCapacityStack<T> implements Iterable<T> {
	private T[] a = (T[]) new Object[1];
	private int N;
	public boolean isEmpty()
	{
		return N == 0;
	}
	public int size()
	{
		return N;
	}
	public void resize(int max)
	{
		T[] temp = (T[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}
	public void push(T item)
	{
		if (N == a.length) resize(2*a.length);
		a[N++] = item;
	}
	public T pop()
	{
		T item = a[--N];
		a[N] = null; // 避免对象游离
		if (N > 0 && N == a.length/4) resize(a.length/2);
		return item;
	}
	public Iterator<T> iterator()
	{
		return new ReverseArrayIterator();
	}
	private class ReverseArrayIterator implements Iterator<T>
	{
		private int i = N;
		public boolean hasNext()
		{
			return i > 0;
		}
		public T next()
		{
			return a[--i];
		}
		public void remove()
		{
			;
		}
	}
	public static void main(String[] args)
	{
		DynamicCapacityStack<String> s = new DynamicCapacityStack<String>();
		while (!StdIn.isEmpty())
		{
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
	
}
