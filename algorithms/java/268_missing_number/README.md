## use hashset
Go through the array and store them in the hashset, and go through the array again and check which number is not in the set.<br>
time: O(2n)<br>
space: O(n)
## sum
Sum all the numbers up and minus all the numbers.<br>
time: O(n)<br>
space: O(1)
## bit operation
We can use xor operation.<br>
Because if two numbers are the same then after xor it is 1, and everything xor 1 will remain the same. Thus we can xor all the numbers and their index we will get the missing number.<br>
time: O(n)<br>
space: O(1)
