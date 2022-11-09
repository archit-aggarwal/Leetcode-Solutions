# Implement Queue using Linked List
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Implement a Queue using Linked List.&nbsp;<br>
A Query&nbsp;<strong>Q</strong>&nbsp;is of 2 Types<br>
<strong>(i)</strong>&nbsp;1 x&nbsp; &nbsp;(a query of this type means&nbsp;&nbsp;pushing&nbsp;<strong>'x'</strong>&nbsp;into the queue)<br>
<strong>(ii)</strong>&nbsp;2 &nbsp; &nbsp; (a query of this type means to pop an element from the queue and print the poped element)</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>Q = 5
Queries = 1 2 1 3 2 1 4 2
<strong>Output: </strong>2&nbsp;3<strong>
Explanation: </strong>n the first testcase
1 2 the queue will be {2}
1 3 the queue will be {2 3}
2 &nbsp; poped element will be 2 the
&nbsp;   queue will be {3}
1 4 the queue will be {3 4}
2 &nbsp; poped element will be 3.
</span>
</pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>Q = 4
Queries = 1 2 2 2 1 3 
<strong>Output: </strong>2 -1<strong>
Explanation: </strong>In the second testcase&nbsp;
1 2&nbsp;the queue will be {2}
2&nbsp; &nbsp;poped element will be {2} then
&nbsp;   the queue will be empty.&nbsp;
2&nbsp; &nbsp;the queue is empty and hence -1
1 3&nbsp;the queue will be {3}.</span>
</pre>

<p><strong><span style="font-size:18px">Your Task:</span></strong><br>
<span style="font-size:18px">Complete the function <strong>push()</strong> which takes an integer as input parameter and <strong>pop()</strong> which will remove and return&nbsp;an element(-1 if queue is empty).</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(1).<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(1).</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;=<strong> </strong>Q &lt;= 100<br>
1 &lt;= x &lt;= 100</span></p>
</div>