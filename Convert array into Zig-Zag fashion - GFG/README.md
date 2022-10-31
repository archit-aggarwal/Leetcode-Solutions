# Convert array into Zig-Zag fashion
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an array&nbsp;<strong>arr</strong> of distinct elements of size&nbsp;<strong>N</strong>, the task is to rearrange the elements of the array in a zig-zag fashion so that the converted array should be in the below form:&nbsp;</span></p>

<blockquote>
<p><span style="font-size:18px"><strong>arr[0] &lt; arr[1] &nbsp;&gt; arr[2] &lt; arr[3] &gt; arr[4] &lt; . . . . arr[n-2] &lt; arr[n-1] &gt; arr[n]</strong>.&nbsp;</span></p>
</blockquote>

<p><span style="font-size:18px"><strong>NOTE:</strong> In the mentioned complexity, only a unique solution will exist.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 7
Arr[] = {4, 3, 7, 8, 6, 2, 1}
<strong>Output: </strong>3 7 4 8 2 6 1
<strong>Explanation:</strong> 3 &lt; 7 &gt; 4 &lt; 8 &gt; 2 &lt; 6 &gt; 1</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 4
Arr[] = {1, 4, 3, 2}
<strong>Output:</strong> 1 4 2 3
<strong>Explanation: </strong>1 &lt; 4 &gt; 2 &lt; 3</span></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>zigZag()</strong>&nbsp;which takes the&nbsp;array of&nbsp;integers&nbsp;<strong>arr&nbsp;</strong>and&nbsp;<strong>n</strong><strong>&nbsp;</strong>as parameters and returns void. You need to modify the array itself.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N)<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= N &lt;= 10<sup>5</sup><br>
0 &lt;= Arr<sub>i</sub> &lt;= 10<sup>6</sup></span></p>

<p>&nbsp;</p>
</div>