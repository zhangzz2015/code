## sort + greedy
We can sort the intervals by start, in that case we can check for each of the interval whether the previous interval end is larger than the current interval start.<br>
if previous.end > current.start: there is intersect between the intervals -> return false<br>

time: O(nlogn + n)<br>
space: O(1)
