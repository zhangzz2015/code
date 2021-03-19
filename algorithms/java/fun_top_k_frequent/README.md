# Find top k frequent visited urls from a long list of visited urls. [a, a, b, c, a, b, b, b].

## offline
Because we want to find the top k highest frequency, this is related to ordering. Thus we can use some sorted or partially sorted data structure.<br>
We want to store the entries with comparing the frequency.<br>
Thus, we can use a minHeap.

time: O(nlogn)<br>
space: O(n)

## online
We want to store top k elements uptill the current element.<br>
We have to record the string's frequency, thus we can use hashmap to store the string and its frequency.<br>
Also we need to update the current topk. We can use a treeset to store the topk elements.

time: record: O(logk) topK: O(k)
space: O(n + k) n is the number of strings

## online hashmap + dll

time: record: O(1) topK: O(k)
space: O(n + k)
