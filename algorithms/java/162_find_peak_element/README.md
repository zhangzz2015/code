## Solution
We can use binary search to find the peak in the array. We can assume that index of -1 and index of array.length is negative infinity. We only need to find one possible local peak. Thus, we can compare the mid with mid + 1.

    if array[mid] < array[mid + 1]:
        left = mid + 1
    else:
        right = mid
No need to do postprocessing because the target is guaranteed to exist.<br>
time: O(logn)<br>
space: O(1)