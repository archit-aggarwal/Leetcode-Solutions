# Longest repeating and non-overlapping substring
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a string <strong>S</strong>, find the longest repeating non-overlapping substring in it. In other words find 2 identical substrings of maximum length which do not overlap. If there exists more than one such substring return any of them. </span> <span style="font-size:18px">Print the longest non-overlapping substring. If no such substring exists print -1.</span></p>

<p><span style="font-size:18px"><strong>Note: </strong>Multiple Answers are possible but you have to print the substring which occurs atleat twice first.</span></p>

<p><span style="font-size:18px">For Example: "ablhiabohi". Here both "ab" and "hi" are possible answers. But you will have to return "ab" as because it repeats before "hi".</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong></span>
<span style="font-size:18px"><strong>N = </strong>13</span>
<span style="font-size:18px"><strong>S = </strong>"geeksforgeeks"</span>
<span style="font-size:18px"><strong>Output:</strong></span>
<span style="font-size:18px">geeks</span>
<span style="font-size:18px"><strong>Explanation:</strong></span>
<span style="font-size:18px">The string "geeks" is the longest Substring
of S which is repeating but not overlapping.</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong></span>
<span style="font-size:18px"><strong>N = </strong>8</span>
<span style="font-size:18px"><strong>S = </strong>"heyhheyi"</span>
<span style="font-size:18px"><strong>Output:</strong></span>
<span style="font-size:18px">hey</span>
<span style="font-size:18px"><strong>Explanation:</strong></span>
<span style="font-size:18px">The string "hey" is the longest Substring
of S which is repeating but not overlapping.</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function<strong> longestSubstring()</strong> which takes a Integer N and a String S as input and returns the answer.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N<sup>2</sup>)<br>
<strong>Expected Auxiliary Space:</strong> O(N<sup>2</sup>)</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= N &lt;= 10<sup>3</sup></span></p>
 <p></p>
            </div>