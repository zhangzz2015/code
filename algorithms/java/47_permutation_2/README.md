## backtracking
Each level we can choose what to fill in the spot. All the elements before the spot is the choosed part, and all the elements on and after the spot are the all possible elements that can be filled into the spot. For one spot, if there are duplicates, all the duplicates fill into the same spot is will make duplicates of the. Thus, we can only fill unique values in each of the spots.

	[1,2,2]
	                   |1 2 3
	             /        |           \
	         1|2 2       2|1 2       pruned
	       /     \       /     \     
	     1 2|2  pruned  2 1|2  2 2|1  
	       |             |      |    
	      122           212    221   

For each level:
- there are nums.length - index number of choices can be swapped to fill in the spot at index
- there are nums.length levels
- to deduplicate the same values on the same spot we can use a set to maintain the value we have used in this spot

time: O(!n)<br>
space: O(n * (n - index))
