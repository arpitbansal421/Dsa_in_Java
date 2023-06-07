package level_up;

import java.util.*;

//One day Squidward, Spongebob and Patrick decided to go to the beach. Unfortunately, the weather was bad, 
//so the friends were unable to ride waves. However, they decided to spent their time building sand castles.

//At the end of the day there were n castles built by friends. Castles are numbered from 1 to n, and the height of the i-th castle is equal to hi. When friends were about to leave, Squidward noticed, that castles are not ordered by their height, and this looks ugly. 
//Now friends are going to reorder the castles in a way to obtain that condition hi ≤ hi + 1 holds for all i from 1 to n - 1.

//Squidward suggested the following process of sorting castles:

//Castles are split into blocks — groups of consecutive castles. Therefore the block from i to j 
//will include castles i, i + 1, ..., j. A block may consist of a single castle.
//The partitioning is chosen in such a way that every castle is a part of exactly one block.
//Each block is sorted independently from other blocks, that is the sequence hi, hi + 1, ..., hj becomes sorted.
//The partitioning should satisfy the condition that after each block is sorted, the sequence hi becomes sorted too. 
//This may always be achieved by saying that the whole sequence is a single block.

//logic 
public class Day_at_beach {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int[]arr=new int[n];
		
		for(int i=0;i<n;i++) {
			
			arr[i]=sc.nextInt();
		}
		
		int[]right=new int[n+1];
		int[]left=new int[n+1];
		
		left[0]=Integer.MIN_VALUE;
		right[n]=Integer.MAX_VALUE;
		
		int pt=1;
		
		for(int i=1;i<n;i++) {
			left[i]=Math.max(left[i-1], arr[i]);
		}
		
		for(int i=n-1;i>=0;i--) {
			right[i]=Math.min(right[i+1], arr[i]);
		}
		
		for(int i=1;i<n;i++) {
			if(left[i]<=right[i]) {
				pt++;
			}
		}
		
		System.out.println(pt);
		
		
	}

}
