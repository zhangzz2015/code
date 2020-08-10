## Given a sorted int array, find the number of pairs of indices i,j, where a[i] + a[j] <= target.<br>[1, 2, 2, 4], target = 5, return 4
For each index j we can find the rightmost i (i is smaller than j) where satisfy that a[i] + a[j] <= target, then because the elements are sorted so the elements in range [0, i] can all form a pair with the elements at index j.<br>
If we starting j from the right then the if j moves left to the next element which is smaller, then if i is starting from the left, i will never move back to the right. Because when element j is smaller which breaks the already satisfied condition and i can only be bigger than before which means move right.<br>
time: O(n)<br>
space: O(1)