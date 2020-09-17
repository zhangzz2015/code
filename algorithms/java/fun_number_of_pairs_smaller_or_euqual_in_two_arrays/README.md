# Given two int arrays a, b, find the number of pairs with diff <= target by picking one element from a, and the other from b.<br>a = [1, 4, 6]<br>b = [2, 8]<br> target = 2
Whether two arrays are sorted? YES<br>
Are there duplicates? YES<br>
How do we count the numbers? We only count once<br>
## We can use two pointers with a sliding window
We need to find all pairs in the two array that has smaller diff between two elements in each of arrays.<br>
- For each j:
    - we want to find the numbers that are in range of [array2[j] - diff, array2[j] + diff]
    - first we find the leftmost element that array1[i] <= array2[j] - target
    - because we have duplicate numbers in the array so we need to know number of the unique number in the range [array2[j] - diff, array2[j] + diff]
    - we also find the rightmost number that array1[i] >= array2[j] + target
    - we update the numbers to the target in the range

When the arrays are sorted and j goes bigger, both leftmost element and rightmost element in array1 will only go right. Thus, we can maintain a sliding window in array1 and we can find all the pairs in the array.<br>
Because there are duplicate numbers we need to maintain a hashmap which records the number and their occurrence, so every time we calculate the pair we just return the size of the array.<br>
time: O(p.length + q.length)<br>
space: O(p.length)
