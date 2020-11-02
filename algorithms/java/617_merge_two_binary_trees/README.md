## recursion
We can use recursion to solve the problem.

input: two root of the subtree.<br>
output: the merged tree of the input<br>
induction rule:<br>
- if a is null or b is null return the other
- both of them are not null:
	- cur.val = a.val + b.val
	- cur.left = merge(a.left, b.left)
	- cur.right = merge(a.right, b.right)

time: O(n) - n is the number of the nodes of the tree with more nodes<br>
space: O(height) - height of the higher tree


## bfs
We can use bfs to traverse the graph. If two of the nodes from each tree are not null then we can add then together into the queue.

time: O(n) - n is the number of the nodes in the larger tree<br>
space: O(n)