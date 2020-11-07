## sliding window
for each j as the end of the substring:
- we want to find the leftmost i as the starting index that the substring from index [i, j] as at most k distinct character
- because there will be duplicate letters in the substring, we need a hashmap to store the letters in the sliding window, and the key would be the character in the sliding window, and the value would be the occurence of the corresponding character.
- while the number of the unique letters in the substring is larger than two then we can move i right and update the elements in the hashmap
- when we are out of the while loop that means the number of the unique letters is smaller or equal than k, than we can update the result.

time: O(n)<br>
space: O(k)
