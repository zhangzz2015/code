## Solution
Because the h-index can onlt be in range [0, length], we can use counting sort which take O(n) time to go through the array and count the number of elements in the original array >= x<br>

    [4, 0, 6, 1, 5] array.length = 5
    search range: 0 1 2 3 4 5 >=6
    occurrence:   1 1 0 0 1 1  1
    # >= x:       5 4 3 3 3 2  1
Go from right to left sum up the number of occurrence of each element, untill we find first x <= (# >= x)<br>
time: O(n)<br>
space: O(n)