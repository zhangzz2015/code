# Given an array of integers and a target, find all combinations with size kequals to target.<br>[2, 3, 4, 6, 7, 9] target = 9, k = 2<br>[2,7], [3,6]
There are duplicate elements in the array. If there are duplicate results we don't add the same.<br>
## backtracking
Because we want to find all the combinations for that condition, we can use backtrackign to solve this problem. Because we want to eliminate the duplicate combinations in the solution. We can sort the array first so that the same element is located consecutively. When we decide not to choose that element in the array we can skip all the same element together gp to the next place we need.<br>
Thus we can have an example like [2, 3, 4, 6, 2, 7, 9, 2, 1], target = 9, k = 2, and we return [2,7], [3,6]<br>
For backtracking recursion tree:<br>
1. Each level we have two branches representing choose or not choose the element at array[level].
2. There are array.length levels of the recursion tree.

                [2, 3, 4, 6, 2, 7, 9, 2, 1]
                [1, 2, 2, 2, 3, 4, 5, 7, 9]
                        [], target=9
                     /                 \
                  [1], 8                [], 9
                /          \          /        \
              [1,2], 6     [1], 8    [2], 7    [], 9
              /     \         |
        prune       [1,2],6   |
                              | skip
                              |
                            /   \
                       [1,3],5  [1],8
                         ....

time: O(2^n) - n is the length of the array<br>
space: O(n)
