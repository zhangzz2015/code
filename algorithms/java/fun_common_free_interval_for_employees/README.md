# We are given a list schedule of employees, which represents the working time for each employee.<br>Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.<br>Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.<br>[1,3),[4,5)<br>[1,2),[6,9)<br>result:[3,4),[5,6)
assumptions:
1. the schedules of each of the employees do not have overlap
2. the schedules of each of the employees are sorted by the starting time<br>
With these two assumptions we can know that all the existing schedules are alined by starting and ending points in all sorted order<br>

For each of the person's list, we can process its interval time and get their free time intervals. Then we merge of current free time intervals into the former free time intervals.

time: O(2 * n) -> O(n) - n is the number of intervals<br>
space: O(n) we need to store the current free intervals for now
