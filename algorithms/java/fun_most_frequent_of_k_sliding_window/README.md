# Most frequent elements for each size k subarray.<br>[1, 2, 1, 3, 3, 3] k = 3.
Assumptions:<br>
- They are not sorted and there are duplicates in the array.
- If there are more than one most frequent element return any of them.

## sliding window
For every size k subarray we want to know the frequency of every element. This brutal force would take O(n^2 * k).<br>
We can use a sliding window of k subarray, so that we can only go through the array once and check each subarray thus we need n * k time.<br>
We can use a treeset to track the frequency inside the window. In the treeset are the element class with two fields 1. the value of the element 2. the frequency of the element. To update each of the element we need a hashmap to store the elemnt value and their frequency.<br>

time: O(n logk)<br>
space: O(k)
