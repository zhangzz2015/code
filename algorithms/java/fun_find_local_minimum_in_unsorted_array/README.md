## Given an unsorted integer array, return the position of any local minimum / maximum.<br> Assumption: no duplicates. <br> +infinity {**1**, 3, **2**, 4 ,5} +infinity
**Solution1**<br>
We can use binary search to solve this problem.<br>

* **case 1: left neighbor > mid < right neightbor** <br>
    mid is the local minimum<br>return mid
* **case 2: left neighbor < mid < right neighbor** <br>
    we can guarantee there is a local minimum on the **left** side<br>right = mid - 1
* **case 3: left neighbor > mid > right neighbor**
    we can guarantee there is a local minimum on the **right** side<br>left = mid + 1
* **case 4: left neighbor < mid > right neighbor**
    we can guarantee there is a local minimum on the **left and right** side<br>left = mid + 1 OR right = mid - 1<br>

**terminate condition:**<br>
1. mid - 1, mid + 1 must all in [left, right]
2. mid - 1, mid + 1 cannot be out of bound

Thus, need to assure that [left, right] search range has at least 3 elements. So while loop condition should be left + 1 < right.

**Solution 2**<br>
***optimization: -loop invariant: int [left, right] there must be a local minimum*
* if array[mid] < array[mid + 1]:<br>right = mid
* else:<br>left = mid + 1

Terminate condition left < right. No need to do postprocessing because the local minimum is guaranteed to exist, and there is only one element left when it terminates.

Time: O(logn)
Space: O(1)