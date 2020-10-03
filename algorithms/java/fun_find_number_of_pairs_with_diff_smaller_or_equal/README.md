# Given two int arrays a, b, find the number of pairs with diff <= target by picking one element from a, and the other from b.<br>a = [1, 4, 6]<br>b = [2, 8]<br>target = 2
## Assumptions:
The two arrays are sorted.<br>
<2,4> and <4,2> only count as one.<br>
There are duplicates in the array.<br>
1 4 4 6<br>
2 2 8<br>
And we only count once for the duplicates.
## two pointers with sliding window
We need to find all pairs in two arrays that has diff smaller than target between two elements in each of arrays.<br>
Thus, for each j:<br>
- we want to find the numbers in array1 that are in range of [array2[j] - target, array2[j] + target]
    - first we find the leftmost element that array1[i] <= array2[j] - target
    - because there are duplicate elements in the array, so we need to know the unique number in the range [array2[j] - target, array2[j] + target]
    - then we need to find the rightmost numver that array1[i] >= array2[j] + target
    - update the number in the range

When the arrays are sorted and j goes bigger, both leftmost element and ritghtmost element in array1 will only go right. Thus, we can maintain a sliding window in array1 and we can find all the pairs in the array.<br>
Because there are duplicate elements in the array, we need to maintain a hashmap which rrcords the number and there occurrence, so every time we calculate the pair we just return the size of the array.<br>

time: O(array1.length + array2.length)<br>
space: O(array1.length)