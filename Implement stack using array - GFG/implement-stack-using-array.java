//{ Driver Code Starts
import java.util.*;

import java.io.*;
import java.lang.*;

class GfG {

	public static void main(String args[])throws IOException
	{
// 		 Scanner sc = new Scanner(System.in);
// 		 int t=sc.nextInt();
         BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
         int t = Integer.parseInt(read.readLine());
         
		 while(t>0)
		 {
			MyStack obj = new MyStack();
			int Q = Integer.parseInt(read.readLine());
			int k = 0;
			String str[] = read.readLine().trim().split(" ");
			while(Q>0)
			{
				int QueryType = 0;
				QueryType = Integer.parseInt(str[k++]);
				if(QueryType == 1)
				{
					int a = Integer.parseInt(str[k++]);
					
					obj.push(a);
					
				}else if(QueryType == 2)
				{
				System.out.print(obj.pop()+" ");
				}
				Q--;
			}
			System.out.println("");
			t--;
		 }
	}
}




// } Driver Code Ends


class MyStack
{
    ArrayList<Integer> arr = new ArrayList<>();
    
	//Function to push an integer into the stack.
    void push(int val) {
        arr.add(val); // insert in the last of arraylist
	} 
	
    //Function to remove an item from top of the stack.
	int pop() {
	    if(arr.size() == 0) return -1; // stack underflow
	    return arr.remove(arr.size() - 1);
	}
}