## high level
We are traversing all the elements in all the lists from small to large.<br>
for each of the element as the smallest element in the tuple:<br>
	- calculate the range with max and min in tuple
	- update the global min
	- pollMin
	- index++
	- offer new

## we can use TreeMap
find max in O(logk)<br>
poll min in O(logk)<br>
offer that in the TreeMap in O(logk)
## use a minHeap and maintain globalmax
Because what we remove is not the max and what we offer has the possibility to be the max.

time: O(nlogk)<br>
space: O(k)
