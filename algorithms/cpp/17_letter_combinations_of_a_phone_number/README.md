## generate one by one
Iteratively create all the possibilities in for each of the digit, and when a new digit comes we can we add all the possiblity candidate for the current digit to all the possibilities before.

time: O(4^n * n)<br>
space: O(1)

## backtracking
For each of the level we can choose from the letters of possibles for that digit.

time: O(4^n * n)<br>
space: O(n)
