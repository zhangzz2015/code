## cycle sort
We know that the answer can only be in the range of [1, length of array]. Thus, if a number appears in this range we can put that into the correspoding index which is num - 1. Then we can go through the array and find the first num that is not the index + 1.

time: O(n)<br>
space: O(1)
