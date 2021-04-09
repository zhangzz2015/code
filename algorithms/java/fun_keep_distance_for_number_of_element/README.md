# Given an integer k, arrayge the sequence of integers [1,1,2,2,3,3,...,k - 1,k - 1,k,k] such that output integer array satisfy the condition of: Between eahc two As there are exactly number of A elements between them. Return all the possible combinations.<br> If k=3 then [3, 1, 2, 1, 3, 2],[2, 3, 1, 2, 1, 3].

## bactracking
For each level we decide where to put one pair of numbers.<br>
There are array.length - 1 - k number of branches.

	                           []
	         /                /       
	      [3,_,_,_,3,_]    [_,3,_,_,_,3]
	     /      
	 [3,_,2,_,3,2]

time: O(k^k)<br>
space: O(k)
