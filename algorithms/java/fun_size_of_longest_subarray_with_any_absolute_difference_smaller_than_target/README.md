# Given an array of integers and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.
For any two pair of elements absolute difference <= limit, this means the largest element and the smallest element in the substring.

return longest size of subarray that absolute difference <= limit<br>
We want to find all the subarrays the scan through the array and find the largest and the smallest. This will need O(n^3) time<br>

## sliding window treemap
for each index j as the ending of the substring:
- we want to find the leftmost i as the starting index which largest - smallest <= limit
- we want to find the largest and the smallest elements in the sliding window, and we can add elements into the sliding window, we can also remove an arbitrary element.
- thus we can use a treeset/treemap, because there can be duplicate elements in the array, we need to use a treemap \<Integer, Integer> \<elements, occurrence>

for the operations we need to do:
- add array[j]
- while i < j and difference > limit: i++, remove array[i]
- if difference <= limit update the longest max(longest, j - i + 1)

time: O(nlogn)<br>
space: O(n)

## sliding window monotonic stack
using two deque:
- non-decreasing: maintaining the candidate for the max number index
- non-increasing: maintaining the candidate for the min number index

time: O(n) - amortized time complexity<br>
space: O(n)

