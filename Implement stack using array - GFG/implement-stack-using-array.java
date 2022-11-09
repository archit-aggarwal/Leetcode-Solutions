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
    int top = 999; // pointing 
	int arr[] = new int[1000];
	
	//Function to push an integer into the stack.
    void push(int val) {
        if(top == -1) return; // stack overflow
        
        arr[top] = val;
        top--;
	} 
	
    //Function to remove an item from top of the stack.
	int pop() {
	    if(top == arr.length - 1) return -1; // stack underflow
	    
	    top++;
	    return arr[top];
	}
}