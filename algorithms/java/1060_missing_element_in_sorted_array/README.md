## Solution
We want to find the kth missing number in the sorted array. <br>
We assume that the numbers in the array is larget than 0.<br>
For each index in the array, to find how many numbers are missing we can:<br>
array[index] - index - offset -> the number of missing numbers in the array before index<br>
here the offset would be the starting number of the array.<br>
Thus, we are searching the index of new array where every element is original_array[index] - index - original_array[0]. And we want to find the largest smaller than k.<br>
* original_array[index] - index - original_array[0] >= k: right = mid - 1
* else: left = mid

Thus the terminate condition should be left == right - 1 where we jump out of the while loop when we left two element. Thus, the while loop condition would be left < right.<br>
For postprocessing we need to consider 1 or 2 elements left.<br>
 if nums[right] - right - offset < k: return k + right + offset
 else: return k + left + offset<br>
 Time: O(logn)
 Space: O(1)
