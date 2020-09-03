# Merge Sort
Using devide can conquer to solve the problem. This sorting algorithm is stable so when sorting the non primitive types are all using merge sort. The average time is larger than quick sort, but this is sorting algorithms is guaranteed to be O(nlogn).
time: O(nlogn)<br>
space: O(n)
## optimize 
Because at every recursion call of the merge step we need to create a new array, and that would be a cost. We can use a helper array to helpe the merge process. In that case there is only one O(n) array is created.<br>
time: O(nlogn)<br>
space: O(n)