## backtracking
From both sides, we fill in the possible character into two sides when the sides.<br>

	"abcab"
	                   _____
	               /           \
	            a___a          b___b
	             /                \
	           ab_ba             ba_ab
	            |                  |
	          abcba              bacab

For each level:
- the possible choice are:
	- if l != r: character frequency >= 2
	- if l == r: character freq == 1
- there are length / 2 levels;

Thus first we can get the frequency of the characters in the string, and we can return empty list if there are more than one odd frequency characters this string cannot form any palindrome.<br>
Then perform backtracking with this count.

time: O(n + (n/2)!)<br>
space: O(n)
