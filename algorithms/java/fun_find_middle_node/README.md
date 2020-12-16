## fast slow pointer
There are two ways to use the while loop condition:
1. fast != null && fast.next != null:
	- odd: return the mid
	- even: return the head of the second half
2. fast.next != null && fast.next.next != null:
	- odd: return the mid
	- even: return the tail of the first half

Usually, using the second way is used more, because after we find mid we usually want to break the linked list and it would be easier to do using the second method.

time: O(n)

space: O(1)
