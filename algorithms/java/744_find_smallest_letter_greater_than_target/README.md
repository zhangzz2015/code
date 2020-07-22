## Solution
We can use binary search to solve this problem.<br>
    
    if array[mid] <= target:
        left = mid + 1
    else:
        right = mid
Thus, the terminate condition is when left = right. -> that means while loop condition is left < right<br>
Than we have to do post processing with one element left.<br>
If the target is larger than the laregst character in the array then we return the first element of the array.<br>
time: O(logn)<br>
space: O(1)