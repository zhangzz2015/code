# solution
To calculate the overall outline of the skyline we need to know the highest height for every spot, and record every height change spot with the corresponding height.<br>
We can make the buildings into points representing the starting point and the ending point of a building and their height. And maintain a maxHeap to know what is the max height of the spot.<br>
From left to right:
- if there is a start point, we add into the maxHeap.
- if there is a end point, we remove the corresponding from the maxHeap<br>
Beacause directly removing the point from the max heap would be O(n) if it is not on the top of the maxHeap. Thus, we can perform a lazy delete. At every spot we just remove if the element at the top of the heap need to be removed. And when we are removing we can remove all the buildings that are already out to the left of that spot.<br>
time: O(nlogn)<br>
space: O(n)
