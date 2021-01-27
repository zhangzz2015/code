## backtracking
When we are generating the parentheses, we can add '(' if left count is smaller than the number of pair. To make it valid, we can add ')' only if there is '(' not paired which means currently there are more '(' than ')' already is added.<br>

	n = 3
	                        ""
	                  /            \
	                 (          cannot add )
	               /    \           
	             ((     ()
	            / \     / \
	          ((( (() ()( cannot add )

for each level:
- we have two branches, if we can add '(' then add '(', if we can add ')' then add ')'
- there are n * 2 levels

time: O(2^n)<br>
space: O(n)
