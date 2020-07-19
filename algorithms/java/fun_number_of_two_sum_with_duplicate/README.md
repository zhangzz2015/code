## 2-sum, how many pairs sum = target(< target, > target). <br>Assumptions:<br>1.sorted array<br>2. there can be duplicate elements
# requirements: we don't count duplucate pairs
e.g. [1, 1, 3, 3] target = 4, return 1<br>
[1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4]<br>
**brutal force:**<br>
for each distinct j -> rightmost index of each duplicate group.
# requirements: we count duplicate pairs
divide the problem **group by group**
e.g. [1, 1, 2, 2, 2, 3, 3] target = 4, return 7
i: left most position of the **group** of duplicate elements.<br>
j: right most position of the **group** of duplicate elements.