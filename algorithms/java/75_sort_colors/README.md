## partition

	array	0000 1111 XXXXX   2222
	             i    j      k
	for i: [0, i) area for 0
	for j: [i, j) area for 1
		   [j, k] area of unknown
	for k: (k, n - 1] area of 2

time: O(n)<br>
space: O(1)
