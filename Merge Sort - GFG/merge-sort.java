//{ Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        StringBuffer sb=new StringBuffer("");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            sb.append(arr[i]+" ");
        System.out.println(sb.toString());
    }

    

	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();
			
			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();
			
			//creating an array of size n
			int arr[] = new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

            
			Solution g = new Solution();
			
			//calling the method mergeSort
			g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}



// } Driver Code Ends


class Solution
{
    public void merge(int[] arr, int left, int mid, int right){
        int[] res = new int[right - left + 1];
        int idx1 = left, idx2 = mid + 1, idx3 = 0;

        while(idx1 <= mid && idx2 <= right){
            if(arr[idx1] <= arr[idx2]){
                res[idx3] = arr[idx1];
                idx1++; idx3++;
            } else {
                res[idx3] = arr[idx2];
                idx2++; idx3++;
            }
        }

        while(idx1 <= mid){
            res[idx3] = arr[idx1];
            idx1++; idx3++;
        }

        while(idx2 <= right){
            res[idx3] = arr[idx2];
            idx2++; idx3++;
        }

        for(int idx = left; idx <= right; idx++){
            arr[idx] = res[idx - left];    
        }
    }
    
    void mergeSort(int nums[], int l, int r)
    {
        if(l == r) return;

        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }
}
