## Solution
We can use a sliding window to solve this problem.<br>
    
    step 1: the property of the sliding window we are interested in.
            product of non-0 values
            # of 0s in the current sliding window
    step 2: 
            add array[fast]     if array[fast] == 0: # of 0s++;
                                                     product * array[fast]
            remove array[slow]  if array[slow] == 0: # of 0s--;
                                                     product / array[slow]
time: O(n)<br>
space: O(1)