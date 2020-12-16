## brutal force
There will also be negative number: deal with the “-” first

The String only contains “-” and numbers, because this is an integer.

There are 4 cases:
1. + and +: subtract
2. - and +: sum
3. + and -: sum
4. - and -: subtract

subtract: larger - smaller<br>
sum: no matter

time: O(n)<br>
space: O(1)
