## Solution
We can use binary search to solve this problem. The search range is the smallest mutiplication and the largest multiplication. Every time search, we compare whether there are k numbers in the multiplication table smaller than k.<br>
time: O(mlog(m * n))<br>
space: O(1)