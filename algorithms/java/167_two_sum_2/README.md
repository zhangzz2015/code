## Solution
We want to find one of all pairs that adds up to the target.<br>
Because the array is sorted.<br>
For all possible j: fix down this dimension going from right to left, we want to find the smallest i, such that array[i] >= target - array[j].<br>
Thus, when j go left -> array[j] is smaller -> array[i] cannot be smaller -> i not move or go right.<br>
time: O(n)<br>
space: O(1)