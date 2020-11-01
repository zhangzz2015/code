## two pointer
We can fix a dimension k, and then for each k, we just need to find the number of pairs i, j that array[i] + array[j] < target - array[k].

For finding the number of pairs because this is a sorted array, we can fix j on the right which is hte biggest number in [0, k -1], and start to count from left to the right.<br>
for each j:
- we need to find the leftmost index array[i] + array[j] >= target - array[k]
	- for the i:
		1. it could be larger or equal than j: but we can only count those are with larger index j. We add number of j to the result.
		2. it could be smaller then the j, then we add number of i to the result

time: O(n^2)<br>
space: O(1)
