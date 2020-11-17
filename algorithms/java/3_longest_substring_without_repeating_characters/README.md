## sliding window
for each index j as the end index:
- we want to find the leftmost i as the starting index without repeating characters

Because we want to check whether the current character is repeated with the letters before, we can use a set to store all the characters of non-repeating substring before the current character at index j(not including j).<br>

for moving j:
- checking is there are repeating before?
	- YES: we need to remove the letters until the letter same with string[j](inclusive)
	- NO: add

When j move right, i will stop at the next of the repeating character. If i go left there will be repeating left for the same j, thus when j move right then i will not move left.

time: O(n)<br>
space: O(n)
