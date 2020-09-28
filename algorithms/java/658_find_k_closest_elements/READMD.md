## find closest and go two side from there
We can find the closest element to the target in the array and go from there compare how many two side which is closest and add that to the result and compare to the next closer.<br>
time: O(logn + k)<br>
space: O(1)

## sliding window
We can use a sliding window to solve the problem. If the number on the right being added is closer to the target than the left most element in the sliding window which is being removed.<br>
time: O(n)<br>
space: O(k) - size k sliding window

## two pointer
We can use two pointer from left and right of the array. We give up the one that is further to the target. When the element left in the range of [left, right] = k which is left - right = k - 1 we terminate.<br>
time: O(n)<br>
space: O(1)