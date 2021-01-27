## backtracking
Each level we can choose what to fill in the spot. All the elements before the spot is the choosed part, and all the elements on and after the spot are the all possible elements that can be filled into the spot.

	[1,2,3]
	                   |1 2 3
				 /        |           \
	         1|2 3       2|1 3        3|2 1
	       /     \       /     \      /     \
	     1 2|3  1 3|2  2 1|3  2 3|1  3 2|1  3 1|2
	       |      |      |      |      |      |
	      123    132    213    231    321    312

For each level:
- there are nums.length - index number of choices can be swapped to fill in the spot at index
- there are nums.length levels

time: O(!n)<br>
space: O(n)
