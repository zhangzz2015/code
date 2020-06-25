## Solution
We can use binary search to find the peak of the mountain array. And then use binary search in each ascending and descending array to find the target.
* **step 1**: find the maximum element's positionin the mountain array -> binary search
* **step 2**: do binary search on the increasing subarray and decreasing subarray to find the target.

Time: O(logn) -> 3 times binary search<br>
Space: O(1)
