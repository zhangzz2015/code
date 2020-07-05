## Solution
A value from array was removed that was not the first or last value in the array.<br>
We can assume that the length of the array is larger or equal than 3.
Because there is only one missing number and all the differences between the adjacent elements are the same. So actually we can calculate the diffrence and calclute the expected number at each index.<br>
For the difference between the adjacent numbers: difference = (array[n - 1] - array[0]) / n<br>
For the expected number at index: array[index] = array[0] + index * difference<br>
Since this is a search problem and we can use bianry search.<br>
We can compare the mid element with the expected number that we can count.<br>
**So we are trying to find the last element that equal to the expected number**<br>
If the expected number is equal to the actual number then the target is in [mid, n - 1], else the missing element is on the [left, mid - 1]<br>
time: O(logn)<br>
space: O(1)
