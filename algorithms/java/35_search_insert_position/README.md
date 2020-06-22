## Solution 1
**step 1** - definition: rightmost index where array[index] < target </br>
**step 2** - binary search

size = 0</br>
size = 1</br>
size = 2   [left, right]</br>
* 2 branches:</br>
    * right = mid - 1 -> [left, left - 1] size = 0
	* left = mid 	  -> [left, right]   size = 2

size = 3   [left, mid, right]
* 2 branches:
	* right = mid - 1   -> [left, left] size = 1
	* left = mid 	    -> [mid, right]   size = 2


## Solution 2
**step 1** - definition: leftmost index where array[index] >= target</br>
**step 2** - binary search

size = 0</br>
size = 1</br>
size = 2   [left, right]</br>
* 2 branches:</br>
    * right = mid   -> [left, left] size = 1
	* left = mid    -> [left, right]   size = 2

size = 3   [left, mid, right]
* 2 branches:
	* right = mid       -> [left, left] size = 1
	* left = mid + 1    -> [right, right]   size = 1

Time: O(logn)
Space: O(1)