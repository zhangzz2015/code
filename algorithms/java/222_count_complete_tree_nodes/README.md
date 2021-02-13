## Solution
A complete tree is a tree that every level is full except the last level, and all nodes in the last level are all to the left.<br>
For a complete binary tree, we can regard them as formed by some complete tree.<br>
For a complete tree if we know the level we can know the number of nodes which would be 2^(level) - 1<br>

for each node:<br>
	we calculate the left subtree level and right subtree level<br>
	if left_level == right_level -> it is a perfect subtree at this level<br>

There are two cases:<br>

	case 1:
	             1
	          /     \
	         2       3
	        / \     / \
	       4   5   6   7
	      / \  /
	     8   9 1
	left subtree is complete
	right subtree is perfect - size = 2 ^ height - 1
	left height == right heigh + 1
	
	case 2:
	              1
	          /       \
	         2         3
	        / \       / \
	       4   5     6   7
	      / \  /\   /
	     8   9 1 2 3
	left subtree is perfect
	right subtree is complete
	left height == right height

	for a complete tree:
	length of the leftmost path of the subtree == height of a complete binary tree


    	calculate left(logn) + calculate right(logn)
               /                     			   \
          logn + logn				        logn + logn
                       					    /         
                                           logn

time: O(log^2(n))<br>
space: O(logn)
