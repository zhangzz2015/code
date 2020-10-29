# Given an array of colors, with k different colors partition then into sorted order.
an array of elements in range from 1 to k.
## usual sort
time: O(nlogn) - n is the number of the length of the array<br>
space: O(1) heap sort or O(nlogn) average and O(n^2) worst with Quick sort or O(n) with merge sort
## partition

	array	1111 2222 333 4444 XXXXXX
	pointer	     1    2   3    4

	for a number array[4] it should be at the spot of pointer[array[4]]
	swap from 4 to the pointer[array[4]]

time: O(n * k) k is the number of the colors<br>
space: O(k)
