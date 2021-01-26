## backtracking with add or not add
For each of the element, we want to decide whether we add this element into the subset or not.

	[1, 2, 3]
	               ""
	           /        \
	          1          ""
	        /   \       /   \
	       12    1     2     ""
	      / \   / \   / \   /   \
	    123 12 13  1 23  2  3   ""

for each level:
- we have two branches: add or not add the element at index
- the height of the tree is the length of the array

time: O(2^n)<br>
space: O(n)

## backtracking with combination
For each level, add a new character to the current subset to conduct a larger sized subset.

	[1, 2, 3]
	                   ""
	             /      |      \
	            1       2       3    size 1 subsets
	           / \     /
	          12 13   23             size 2 subsets
	         /
	        123                      size 3 subsets

for each level:
- we have nums.length - index choices, all numbers that are not added into the subset can be add into it
- the height of the tree is the largest subset size

time: O(!n)<br>
space: O(n)
			 
