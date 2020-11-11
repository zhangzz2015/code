# In this month of 30 days, you need to finish a work needs 20 days to finish. The regulations require that any employee cannot work for more than 5 dyas consecutively. Print out all the possible schedules that are feasible to finish the project.
for a work plan for 30 days, we can represent them as 0 for break, and 1 for work, and print out 30 numbers representing each day.

## backtracking
We can use backtracking to solve this problem.<br>
For each level i of the recursion, we are deciding whether we can use this i-th day as break or work. There are 30 levels of the recursion tree.<br>
In the recursion, we also need to do some pruning, every time we want to make a day as work day we need to check the last time of the break to know that if we excede the limit of working 5 days consecutively. And if we are using more than 30 days. Thus we need to pass down the information of the last break day.<br>


	day0				[]
				      /     \
	day1             0       1
                    /  \    / \ 
	day2           0    1  0   1

	...

	day30

time: O(2^30)<br>
space: O(30)
