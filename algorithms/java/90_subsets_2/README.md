For this problem, we need to deduplicate for the same value.
## backtracking add or not add
For each of the element, we want to decide whether we add this element into the subset or not. To avoid same subsets to appear, if we choose not to add one element we need to skip all the elements for the same value. To avoid the same value, we can sort the array to make the same element placed together. 

	[1, 2, 2]
	               ""
	           /        \
	          1          ""
	        /   \       /   \
	       12    1     2     ""
	      / |   / \   / |   /   \
	    122 | 12   1 22 |   2   ""

for each level:
- we have two branches: add or not add the element at index
- the height of the tree is the length of the array

time: O(nlogn + 2^n)<br>
space: O(n)

## backtracking with combination
For each level, add a new character to the current subset to conduct a larger sized subset. For the same level we cannot add the same element twice, so we sort the array and skip it on the same level.

	[1, 2, 2]
	                   ""
	             /      |      \
	            1       2  will be skipped      size 1 subsets
	           / \     /
	          12 skip 22                        size 2 subsets
	         /
	        122                                 size 3 subsets

for each level:
- we have nums.length - index choices, all numbers that are not added into the subset can be add into it
- the height of the tree is the largest subset size
- we need to skip the same element in the 

time: O(nlogn + !n)<br>
space: O(n)

