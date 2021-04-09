# Reverse linked list group by group in size k. But we need to reverse the remaining nodes even if the remaining is less then k.
## iterative
Reverse each k group and link to the parts that are reversed before.<br>
We will traverse the linked list group by group, and reverse each group.
for each of the group:
1. each time we start from the head of the k group
2. count k nodes after
	- there are more than k nodes after -> return the k node
	- there are no more than k nodes -> return null
3. reverse k nodes part
	- because we want to reverse the k nodes part, we can break the last node: kNode.next = null
	- because we need to break and link the rest of the node back, we need to maintain a next node which is the head of the part of the rest of the non-reversed part of the list.
4. linked the reversed k nodes to the previous answers
	- thus we need to maintain a previous node which is the last node of the reversed part. used to link the new reversed k nodes.
5. termination
	- when cur == null : there is no next group.

time: O(n)<br>
space: O(1)
## recursive
Same idea.

time: O(n)<br>
space: O(n / k)
