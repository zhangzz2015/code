## Solution
To decide whether a substring is the anagram of the target string: they have the same kinds of the characters and same amount of each character.<br>
We can use a sliding window to go through the string and for the elements in the sliding window we maintain a hashmap that represents the number of each kind of element that needs to be matched.<br>
n is the length of the string<br>
time: O(n)<br>
space: O(m) m is the length of the target