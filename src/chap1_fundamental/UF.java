package chap1_fundamental;

import edu.princeton.cs.algs4.*;

// 检查连通性的Union Find算法
public class UF {
	private int[] id;	// 分量id，以触点作为索引
	private int count;	// 分量数量
	public UF(int N)
	{
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	public int count()
	{	return count;	}
	public boolean connected(int p, int q)
	{	return find(p) == find(q);	}
	// quick find算法
//	public int find(int p)
//	{
//		return id[p];
//	}
//	public void union(int p, int q)
//	{
//		int pID = find(p);
//		int qID = find(q);
//		if (pID == qID) return;
//		for (int i = 0; i < id.length; i++)
//			if (id[i] == pID) id[i] = qID;
//		count--;
//	}
	// quick union算法
	public int find(int p)	// 找出它的根结点
	{
		while (p != id[p]) p = id[p];
		return p;
	}
	public void union(int p, int q)
	{
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) return;
		id[pRoot] = qRoot;
		count --;
	}
	public static void main(String args[])
	{
		int N = StdIn.readInt();
		UF uf = new UF(N);
		while (!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) continue;
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + "components");
	}
}
