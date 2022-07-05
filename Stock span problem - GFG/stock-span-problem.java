// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        Stack<Integer> stk = new Stack<>();
        int[] span = new int[n];
        
        for(int i=0; i<n; i++){
            
            // 1. Pop Elements Smaller than Us
            while(stk.size() > 0 && price[stk.peek()] <= price[i]){
                stk.pop();
            }
            
            // 2. If Stack is Not Empty 
            if(stk.size() > 0){
                span[i] = i - stk.peek();
            } else {
                span[i] = i + 1;
            }
            
            
            // 3. Push Ourself
            stk.push(i);
        }
        
        return span;
    }
    
}