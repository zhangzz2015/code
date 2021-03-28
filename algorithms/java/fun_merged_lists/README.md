# Given head pointers to two singly-linked lists, how do you test if the two lists join to one list at some point?

## solution
Both of the list may have cycle in it. Thus we can talk about each of the cases seperately.<br>

1. Neither lists have cycle
    - case 1.1: if join, two tail nodes are the same
    - case 1.2: if not join, two tail nodes are not the same
2. Both lists have cycle
	- case 2.1: if join, both lists end up in the same cycle. Iterate through one cycle, and check if one pointer reach the other.
	- case 2.2: if not join, lists end up in different cycles. In one iteration, the two pointer never meet
3. one list has cycle and the other does not
	- The two lists does not join

We can first get the tail of each of the list, and check if they are in the same cycle.

time: O(m + n)<br>
space: O(1)
