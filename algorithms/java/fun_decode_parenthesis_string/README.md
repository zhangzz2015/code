# Decode a String that has pattern [n|string] -> n number of the string. [3|ABC] -> ABCABCABC.<br>HG[3|B[2|CA]]F<br>HGBCACABCACABCACAF
We can use recursion to solve the problem. When we encounter a '[' we can go into the next subarray and when we meet a ']' we can calculate the decoded substring with in this the [...].

			      HG[   BCACABCACABCACA F
				  /      ^
				 /       |
			  3|B[     CACA]
		      /         ^
		     /          |
		  2|CA] ->    CACA

time: O(n) - n is the length of the whole string<br>
space: O(depth)
