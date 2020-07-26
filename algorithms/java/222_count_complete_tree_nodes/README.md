## Solution
A complete tree is a tree that every level is full except the last level, and all nodes in the last level are all to the left.<br>
For a complete binary tree, we can regard them as formed by some complete tree.<br>
For a complete tree if we know the level we can know the number of nodes which would be 2^(level) - 1<br>

for each node:<br>
	we calculate the left subtree level and right subtree level<br>
	if left_level == right_level -> it is a perfect subtree at this level<br>

    	calculate left(logn) + calculate right(logn)
               /                     			   \
          logn + logn				        logn + logn
                       					    /         
                                           logn
time: O(log^2(n))<br>
space: O(logn)
