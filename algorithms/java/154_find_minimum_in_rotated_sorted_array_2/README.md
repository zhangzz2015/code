## Solution
Because we want to find the minimum number in the rotated sorted array that **has duplicate**. I think we can use binary search to solve this problem. If the array is null we can return -1. If there is 0 elements in the array then we can return -1.<br>
For this rotated sorted array, whenever we find a mid there is going to be at least one in [left, mid] or [mid, right] is in a strict ascending order. To find out which part is the strict ascending part we can compare array[mid] with array[right]
* **if array[mid] == array[right]**: right = right - 1, in this situation we cannot determine which half to go. But we need to keep the invariant -> target in the next round's [left, right], also to **reduce** the size of the search range we can exclude the element where right is.
* **if array[mid] < array[right]**: right = mid, because mid might be the smallest one, but all numbers right to mid is not possible to be the smallest in the array.
* **array[mid] > array[right]**: left = mid + 1, because the [mid, right] part of the array is not the strict ascending part. And that is where the minimum number can be. Also, mid can be excluded, because there are element that is smaller than mid(assumption: no duplicate).<br>

For terminate condition: <br>
size = 3: [left, mid, right] -> [left, left + 1] size of 2 or [right, right] size of 1<br>
size = 2: [left(mid), right] -> [left, left] size of 1 or [right, right] size of 1<br>
So we can terminate when left == right which makes the while loop condition to be left < right.<br>
Because we are finding min value in the array, that is guaranteed to be exist in the array so we don't need to postprocessing.<br>
Time: O(logn)<br>
Space: O(1)