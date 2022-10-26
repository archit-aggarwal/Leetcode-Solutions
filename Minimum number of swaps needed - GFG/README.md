# Minimum number of swaps needed
## Easy
<div class="problems_problem_content__Xm_eO"><div><span style="font-size:18px">Given an array <strong>arr[]</strong> of size <strong>N</strong> of non negative integers. We can perform a swap operation on any two adjacent elements in the array. The task is to find the minimum number of swaps needed to sort the array in non - decreasing order. </span></div>

<div>&nbsp;</div>

<p><span style="font-size:18px"><strong>Example 1:</strong> </span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N = 4<span style="font-size:18px">
arr[] = {4, 1, 2, 3}
</span><span style="font-size:18px"><strong>Output:</strong> 3
<strong>Explanation</strong>: </span></span><span style="font-size:20px">(4,1,2,3) -&gt; (1,4,2,3) -&gt; 
(1,2,4,3) -&gt; (1,2,3,4). Hence we need 
a total of 3 swaps to sort it in 
non - decreasing order.</span></pre>

<p><span style="font-size:18px"><span style="font-size:18px">â€‹<strong>Example 2:</strong> </span></span></p>

<pre><span style="font-size:18px"><span style="font-size:18px"><strong>Input</strong>: <span style="font-size:18px">
N = 4
arr[] = {4, 4, 2, 3}
<strong>Output:</strong> 4
<strong>Explanation</strong>: </span></span></span><span style="font-size:20px">(4,4,2,3) -&gt; (4,2,4,3) -&gt;
(4,2,3,4) -&gt; (2,4,3,4) -&gt; (2,3,4,4,).
Hence we need a total of 4 swap to 
sort it in increasing order.</span></pre>

<p><span style="font-size:18px"><span style="font-size:18px"><span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Your task is to complete the function </span></span><strong><code>countSwaps</code></strong><span style="font-size:18px"><span style="font-size:18px"><strong>()</strong>&nbsp;which takes the array <strong>arr[]</strong> and <strong>N</strong><strong> </strong>as inputs and returns the </span></span>minimum number of swaps needed to sort the array in non - decreasing order.<br>
<br>
<span style="font-size:18px"><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(NlogN)<br>
<strong>Expected Auxiliary Space:</strong> O(N)</span><br>
<br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>4</sup><br>
1 ≤ arr[i] ≤ 10<sup>9</sup></span></span></span></p>

<p>&nbsp;</p>
</div>