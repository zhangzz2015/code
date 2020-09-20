## solution
clarification:
1. input, output: ouput is a String, then how to represent multiple digits.
2. will there be duplicate value? to decide the solution
3. online/offline: if ouput is very large, we need online so we don't need to store all things in the memory.

Binary tree, int value, not single digit, ouput is a string.<br>
We need a special character to represent the null nodes, we also need a delimiter to seperate each nodes, because not all integer are single digits.<br>

We can use preorder and level order with a duplicate to serilize the tree. And there is another way of serialize which use pre/post/level order + inorder. And because after serialize we need to transport these information with internet and smaller size would occupy smaller internet bounds. Plus, when we deserialize it the bottleneck would be in the IO for reading all data into the memory and reconstruct that. Thus, in this senerio we want to prioritize space complexity than time complexity.<br>
We need O(2n) with pre/post/level + in, using special signal we need O(2n) in worst case. But we can optimize, for example when we reach the number of nodes the following # is not need. And for leaf node there are two # we can use a $ to note two #. Also there are alot of continuos # we can transfer that to 3# to note # # #.<br>

time: O(n)<br>
space: O(n)
