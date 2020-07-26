## Solution

    We want to use a data structure to perform:
        - add array[fast] -> O(1) amortized
        - remove array[slow] -> O(1)
        - get max -> O(1)
    To make all these operations efficient. We can make a monotonically decreasing deque to store the candidates that can be maximum value in the following sliding window.
    If a new value enters the sliding window all the elements before which are smaller than the current element can be eliminated from the deque on the right side. 
    Also the if the element is out of the sliding window we need to remove that out of the deque from the left side of the deque
    time: O(n)
    space: O(k)