# Determine if the binary tree is a perfect tree.

## BSF
For each level: it has to be full
- size of the current level: two ways
	1. number of nodes at level i is 2^i
	2. number of nodes at current level = 2 * number of nodes at previous level

time: O(n)<br>
space: O(n)

## pure recursion

				1
              /   \
             2     3
            / \   / \
           4   5 6   7
          / \  /\
         8   9 1 2
	 The induction rule should be left subtree and right subtree are all perfect tree and the height are the same.  

For each of the node:<br>
- determine whether the subtree of this node as root is perfect tree
- left subtree and right subtree are all perfect tree and the height are the same.

The return value should contain two information: 1. perfect or not and height<br>
Thus, we can create a return type class. But to optimize, we can suppress use one int value as the return type:<br>
height >= 0: isPerfect == true<br>
height < 0: isPerfect == false<br>
time: O(n)<br>
space: O(height) -> O(logn)
