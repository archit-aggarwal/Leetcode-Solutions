// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function Template for C++
class Solution
{
	public:
    int gcd(int n, int d) 
	{ 
	    if(n % d == 0) return d;
	    return gcd(d, n % d);
	} 
};

// { Driver Code Starts.

int main() 
{
   	int t;
    cin >> t;
    while (t--)
    {
        int A, B;
        cin >> A >> B;
        Solution ob;
       	cout <<  ob.gcd(A, B) << "\n";
    }
    return 0;
}  // } Driver Code Ends