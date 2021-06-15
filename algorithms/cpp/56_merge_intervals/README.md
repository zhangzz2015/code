## brutal force
We can first sort the intervals by the start time.<br>
Then for each of the interval:
- if the current interval has intersection with the last one in the result. Update the last one's end in the result.
- if the current interval has no intersection with the last one in the result. We can add this interval to the result.

time: O(nlogn + n)<br>
space: O(1)
