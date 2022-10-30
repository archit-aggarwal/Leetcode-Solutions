# Rearrange Array Alternately
## Medium
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a sorted array of positive integers. Your task is to rearrange&nbsp; the array elements alternatively i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on.<br>
<strong>Note:&nbsp;</strong>Modify the original array itself.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 6
arr[] = {1,2,3,4,5,6}
<strong>Output: </strong>6 1 5 2 4 3<strong>
Explanation: </strong>Max element = 6, min = 1, 
second max = 5, second min = 2, and 
so on... Modified array is : 6 1 5 2 4 3.</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 11
arr[]={10,20,30,40,50,60,70,80,90,100,110}
<strong>Output:</strong>110 10 100 20 90 30 80 40 70 50 60<strong>
Explanation: </strong>Max element = 110, min = 10, 
second max = 100, second min = 20, and 
so on... Modified array is : 
110 10 100 20 90 30 80 40 70 50 60.</span>
</pre>

<p><span style="font-size:18px"><strong>Your&nbsp;Task:</strong><br>
The task is to complete the function <strong>rearrange</strong>() which rearranges elements as explained above. Printing of the modified array will be handled by driver code.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N).<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1).</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= N &lt;= 10</span><sup><span style="font-size:15px">6</span></sup><br>
<span style="font-size:18px">1 &lt;= arr[i] &lt;= 10</span><sup><span style="font-size:15px">7</span></sup></p>
</div>