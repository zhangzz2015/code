## sliding window
We want to find all the substrings of length k with no repeating characters.<br>
for each of the index j as the end index of the substring:<br>
we want to find the leftmost i making the substring with no repeating characters, and check if the size is larger or equal to k.<br>

Because we want to know whether there are duplicates, we can use a hashset to record the non repeating characters before the index j.<br>
- we can first move the i right when there are still duplicate element with the character at index j.
- then we can add character at index j into set.
- update the result when set.size() >= k

time: O(n)<br>
space: O(n)

## sliding window
For each of the index j as the ending index of the size k substring:<br>
- we want to know the number of different letters in substring [j - k + 1, j]
- if # of different letters == k: res++
- else: do nothing
To know the different letters in substring [j - k + 1, j], we can use a hashmap to record the characters and their occurrence. the key value pair would be \<Character, Integer><br>
Because we only care about the substring of length k, when j goes right, we only need to remove letter at index j - k, and add the character at index j.<br>
- first add character at index j into the map
- if j >= k: we need to remove the letter on the index j - k
- update the res when j >= k - 1 && occurrence.size() == k -> res++

time: O(n)<br>
space: O(k)

