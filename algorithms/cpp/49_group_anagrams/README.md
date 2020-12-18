## map
To know whether two words are in the same anagram group, we can sort them and if the are the same then they are in the same group.

We can use a hashmap to store the sorted pattern mapping to its corresponding group members.

time: O(nklogk)<br>
space: O(n);
