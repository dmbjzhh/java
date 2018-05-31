package chap1_fundamental;
// 容量固定的栈，支持不同类型，只支持String类型的话把T都改为String即可
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings<T> {
	private T[] a; // stack entries
	private int N; // size
	public FixedCapacityStackOfStrings(int cap)
	{	a = (T[])new Object[cap];	}
	public boolean isEmpty() {	return N == 0;	}
	public int size() {	return N;	}
	public void push(T item)
	{
		a[N++] = item;
	}
	public T pop()
	{
		return a[--N];
	}
	public static void main(String[] args)
	{
		FixedCapacityStackOfStrings<String> s;
		s = new FixedCapacityStackOfStrings<String>(100);
		while (!StdIn.isEmpty())
		{
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty())	StdOut.print(s.pop()+" ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}
