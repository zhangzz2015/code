## Solution
If the input array is sorted we can use binary search to find the h index.<br>

                               [0, 1, 3, 5, 6]
    index                       0  1  2  3  4
    f(x)= # of elements >= x    5  4  3  2  1
                                T  T  T  F  F
time: O(logn)<br>
space: O(1)
