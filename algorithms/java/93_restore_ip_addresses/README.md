## backtracking
In high-level, we want to try each possible ways to decode each part of the IP addresses.<br> 
We can use backtracking to solve this problem.<br>
For each level, there are at most three possible ways to decode one part.<br>
There are 4 levels.<br>
For the decoding part, the part need to be in the range of [0,255] inclusively. And there should not be a number that have leading 0s like 001.<br>

	                             ""
	                       /      |          \
	first part        1 digit   2 digit    3 digit
	                  /  | \
	second part      ...
	                / | \
	third part     ...
	              / | \
	fourth part  ....

time: O(3^4 * 17)<br>
space: O(4)
