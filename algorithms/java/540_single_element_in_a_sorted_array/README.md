## Solution
We can use binary search to find the missing number.<br>

    [1, 1, 3, 3, 7, 7, 10]
             mid
    [1, ,3, 3, 7, 7, 10, 10]
              mid
    [1, 1, 3, 7, 7]
          mid
    [1, 1, 3, 3, 7]
          mid
    If the number of elements in (mid, right] is odd number:
        if array[mid] == array[mid + 1]:
            left = mid + 1
        else:
            right = mid
    If the number of elements in (mid, right] is even number:
        if array[mid] == array[mid + 1]:
            right = mid - 1
        else:
            left = mid + 1
No need to post processing, because the target we want to find is guaranteed to be exist.<br>
time: O(logn)<br>
space: O(1)