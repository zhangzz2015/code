## backtracking
For each level, we are adding one element into the combination. And we will not add the elements that are already added, so we can perform an order trick which is add from the smaller elements and add the elements larger than the elements that are already added.

	n = 4, k = 2
	                        []
	              /      |      |    \
	             1       2      3     4
	           / \ \    / \    / 
	         12 13 14  23 24  34

For each level i:
- we have n - i choices to add into the current combination
- there is k levels

time: O(n * (n - 1) * .. * (n - k))<br>
space: O(k)
