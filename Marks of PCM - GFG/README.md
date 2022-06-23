# Marks of PCM
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">You are provided with marks of <strong>N</strong> students in Physics, Chemistry and Maths.<br>
Perform the following 3 operations:&nbsp;</span></p>

<ul>
	<li><span style="font-size:18px">Sort the students in Ascending order of their Physics marks.</span></li>
	<li><span style="font-size:18px">Once this is done, sort the students having same marks in Physics in the descending order of their Chemistry marks.</span></li>
	<li><span style="font-size:18px">Once this is also done, sort the students having same marks in Physics and Chemistry in the ascending order of their Maths marks.</span></li>
</ul>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N = 10
phy[] = {4 1 10 4 4 4 1 10 1 10}
chem[] = {5 2 9 6 3 10 2 9 14 10}
math[] = {12 3 6 5 2 10 16 32 10 4}
<strong>Output:
</strong>1 14 10
1 2 3
1 2 16
4 10 10
4 6 5
4 5 12
4 3 2
10 10 4
10 9 6
10 9 32
<strong>Explanation</strong>: Firstly, the Physics marks of 
students are sorted in ascending order.
Those having same marks in Physics have
their Chemistry marks in descending order.
Those having same marks in both Physics
and Chemistry have their Math marks in
ascending order.
</span>
</pre>

<p><strong><span style="font-size:18px">Your Task:</span></strong></p>

<p><span style="font-size:18px">You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>customSort()&nbsp;</strong>which takes &nbsp;<strong>phy</strong>[],&nbsp;&nbsp;<strong>chem</strong>[],&nbsp;&nbsp;<strong>math</strong>[]&nbsp; and an integer <strong>N </strong>denoting the marks and the number of students. The function sorts the marks in the described order and the final changes should be made in the given arrays only.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(NLogN).<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(N).</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= N &lt;= 10000</span></p>
 <p></p>
            </div>