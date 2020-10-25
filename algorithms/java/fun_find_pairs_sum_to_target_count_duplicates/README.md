# Given a sorted array, find the number of pairs that sum euqal to target. For duplicates elements and we count duplicate pairs.
e.g. [1, 1, 2, 2, 2, 3, 3] target = 4, return 7
For each of the element in the array:<br>
- if we find array[i] + array[j] == target
	- if array[i] != array[j]: we want to find the number of the elements equal to array[i] and the number of elements equal to array[j]. Thus, there are n * m combinations. 
	- if array[i] == array[j]: we want to know the number of elements of array[i] or array[j]. And we count the number as C(2, n) -> choose two from the number of the same elements.
- if array[i] + array[j] < target:
	- i++
- if array[i] + array[j] > target:
	- j-- for the current j we already find the number of i, so we try to find the next j

time: O(n)<br>
space: O(1)
