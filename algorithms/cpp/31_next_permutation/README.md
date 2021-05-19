## solution
For a part descending part of the number we cannot find the next permutation, because this is the largest number with these numbers. So if we find the first that decrease from right to left, we can find the smallest number that is larger than the decreasing number. And we can change the first decreasing number to the smallest larger number that we find after it, and use the rest numbers to make the smallest numer.

time: O(n)<br>
space: O(1)
