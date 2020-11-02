## two pointers
We want to find all the triples and return the sum of them with the closest to the target. If we use brutal force that means we have 3 dimensions, and there are O(n^3) possible. Thus we need O(n^3) time.

If we want to optimize, we can first sort the array.<br>
We fix one dimension first.<br>
For each k:
- we want to find the pair sum that is the closest to target - array[k] that i \< j \< k


for each j:
- we want to find the leftmost i that arra[i] + array[j] >= target
	- for the larger i will only make sum further larger than the target.
- When j moves left array[j] will decrease, to make the sum larget than the same target i can only move right or not move. The larget j cannot pair with those smaller i to make the sum >= target, when j goes left it still cannot.

time: O(nlogn + n^2)<br>
space: O(1)
