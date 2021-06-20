## two pointer
[0,slow): the elements left.<br>
[slow,fast): the elements processed, and not needed<br>
fast: the element that is processing.<br>
We can compare the nums[fast] to nums[slow = 2], because the numbers are sorted we can guarantee that nums[fast] will be either larger or equal to nums[slow - 2]. If they are not equal then the current element is not repeated twice.

time: O(n)<br>
space: O(1)
