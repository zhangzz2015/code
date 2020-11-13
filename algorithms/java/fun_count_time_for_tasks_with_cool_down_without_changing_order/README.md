# Given list of task like AABCABA, execute a task need 1 second, and the cooldown time for the same task is k. The order of the tasks can not be changed. Count the total time to execute all the tasks.

for brutal force:
- iterate through every task
- for each task determine the time for the 
- for each task
	- if haven't executed before: time++
	- if executed before: time = max(lastTim + k + 1, time + 1)

time means: when iterate to the current task, the execution time of the last task. (the time we used when we execute before the current task)

## sliding window
for each task, we only need to care about the tasks and their execution time in the last k mins.<br>
To represent the sliding window, we need to maintain the access order, thus we can use a queue.<br>
For the queue, it will contains the tasks in the last k mins when we iterate to the current task.

time: O(n)<br>
space: O(k)
