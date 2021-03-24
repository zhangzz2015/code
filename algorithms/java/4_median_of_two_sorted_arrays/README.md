## recursion
We can use recursion to solve this problem. We can eliminate half of what search range starting from the total of the two array.<br>
For array A and array B:<br>
- if A[k/2 - 1] <= B[k/2 -  1]: eliminate all elements before k/2 - 1 in A
- else: eliminate all elements before k/2 - 1 in B
- for terminate: when one array is out of element; when k = 1: return min(A[0], B[0])

time: O(log(m + n))<br>
space: O(log(m + n))
