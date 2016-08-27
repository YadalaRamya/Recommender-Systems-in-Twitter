package com.algo.top20.basic;
import java.util.HashSet;
import java.util.Random;

public class FindDuplicate {
public static int findDuplicate1(int[] in)
{
	HashSet<Integer> hs= new HashSet<Integer>();
	for(int e:in)
	{
		if(hs.contains(e))
			return e;
		else 
			hs.add(e);
	}
		return -1;
}
public static int findDuplicate2(int[] in)
{
	
	for(int e:in)
	{
		if(in[ Math.abs(e)]<0)
			return Math.abs(e);
		else 
			in[ Math.abs(e)]=-1;
	}
		return -1;
}
public static int findDuplicate3(int[] in)
{
	
	for(int e:in)
	{
		if(in[ Math.abs(e)]<0)
			return Math.abs(e);
		else 
			in[ Math.abs(e)]=-1;
	}
		return -1;
}
public static void main(String[] args)
{
	Random r= new Random(100);
	int n =Integer.parseInt(args[0]);
	int[] in = new int[n];
	
	for(int i=0; i<in.length;i++)
	{
		in[i] = r.nextInt(n-2)+1;
	}
		System.out.print(findDuplicate1(in));
		//System.out.print(Array.toString(in));
}
}

