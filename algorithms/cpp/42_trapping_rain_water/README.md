## use a stack
For each of the heights:<br>
- current height is larger than stack top, we can add into the result of the distance and the height.

We are maintaining a non-increasing stack.

time: O(n)<br>
space: O(n)

## greedy
We can keep a left and right max. Once we find a block is smaller than max that means the height in between them can be filled with water.<br>
We want to process the smaller side first. In this case when finished all the smaller ones will not miss.

time: O(n)<br>
space: O(1)
