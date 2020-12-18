## backtracking
For each of the row, we want to try all the columns for each row.<br>
We want to use backtracking to solve this problem.<br>
For each level i we are deciding which column on row i to put the queen on.<br>
There are n levels. We can maintain a length n array representing the column number each row has a queen on.

	               []
	           /      \ \ \ \\ \
	         0        1  2 ...  n
	       /\  \ \  \ 
	      00 01 02 ...0n   ...
	      ....

We can use a boolean array to represent the state of which columns are free or not free.<br>
To represent the diagonal, we can also use two arrays.

	for right-top to left-bottom diagonal
	there are n * 2 - 1 diagonals
	if n = 4
	0 1 2 3
	/ / / /  4   the number can be represented as row + col
	0 1 2 3 /5
	1 2 3 4 /6 
	2 3 4 5 /
	3 4 5 6 

	for left-top to right-bottom diagonal
	there are n * 2 - 1 diagonals
	if n = 4
	 3 4 5 6
    2 \ \ \ \     the number can be represented as n - 1 + col - row 
	1\ 3 4 5 6      
	0\ 2 3 4 5
	 \ 1 2 3 4
	   0 1 2 3

time: O(!n)<br>
space: O(n)
