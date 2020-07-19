# 2-sum, how many pairs sum = target(< target, > target). <br>Assumptions:<br>1.sorted array<br>2. there can be duplicate elements
## requirements: we don't count duplucate pairs
e.g. [1, 1, 3, 3] target = 4, return 1<br>
[1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4]<br>
**brutal force:**<br>
for each distinct j -> rightmost index of each duplicate group.
## requirements: we count duplicate pairs
divide the problem **group by group**
e.g. [1, 1, 2, 2, 2, 3, 3] target = 4, return 7
i: left most position of the **group** of duplicate elements.<br>
j: right most position of the **group** of duplicate elements.
# If the array is not sorted, number of pairs of sum to target.
starting from brutal force: find all pairs.<br>

    for each j:
    how many index i such that i < j, array[i] + array[j] == target
    -> how many elements are there in **[0, j - 1]** which has the value of target - array[j] -> the meaning of HashMap
    use HashMap to optimize the look up
