## Solution
Because we want to find the target number in the rotated sorted array that has no duplicate. I think we can use binary search to solve this problem. If the array is null we can return -1. If there is 0 elements in the array then we can return -1. If we cannot find the target number we return -1.<br>
**We compare mid with right -> determine which half is in sorted**
* **if array[mid] < array[right]**:
    * if the target is in the range [mid, right]: left = mid + 1
    * else: right = mid - 1;
* **else**:
    * if target is on the side that has rotated which is [mid, right] in this case: left = mid + 1
    * else right = mid -1

For the termination condition
size = 3: [left, mid, right] -> [left, left] size of 1 or [right, right] size of 1<br>
size = 2: [left(mid), right] -> [left, left] size of 0 or [right, right] size of 0<br>
size = 1: [left(mid)(right)] -> [left, left - 1] size of 0 or [right + 1, right] size of 0<br>
So we can terminate when size is 0 which would be left > right, and that makes the while loop condition to be left <= right.

Time: O(logn)<br>
Space: O(1)