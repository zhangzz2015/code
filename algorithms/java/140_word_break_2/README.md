## backtracking
We decode the parts of the string in the string word by word. For each level, we add all possible word starting from the index.

	                   ""
	               /  \  \   \
	             w1   w2  w3  w4
	           /  \
	          w3  w5 ...
	          ...

For each level:
- the branches are all the possible words that can start from that index
- the levels are the number of words this string can form

time: O((possible words)^(number of words))<br>
space: O(number of words)

## recursion with memoization
For an index, all the possible combination of words are the same. They all need to add the same of word after it.<br>
Thus, we can use the index to memoize all the results.<br>

time: O(n^2 + 2^n)<br>
space: O(number of words)
