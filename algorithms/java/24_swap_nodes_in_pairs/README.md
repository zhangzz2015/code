## iterative

			h         n
	prev -> 1 -> 2 -> 3 -> 4
	dummy-> 2 -> 1 -> 3 -> 4

for each node as the first node of the four nodes<br>
record the next pair head as next: next = head.next.next<br>
new head is the next of prev: prev.next = head.next<br>
link second node to the first node: head.next.next = head<br>
link head to the next: head.next = next<br>
move to next: prev = head; head = next;

time: O(n) - n is the length of the linkedlist<br>
space: O(1)
## recursion

	h    n
	1 -> 2 -> 3 -> 4
	2 -> 1 -> | swaped |

for each node as head:<br>
record next first: next = head.next<br>
put swaped rest of the list to the next of the head: head.next = swap(head.next.next)<br>
link head to the next: next.next = head<br>
return the new head which is the next

time: O(n)<br>
space: O(n / 2)

