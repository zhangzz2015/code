## Solution
**target definition** = largest integer such that x^2 <= num f(x) = (x^2 <= num)
**What is the sorted range to search?**<br>
[1, num] -> optimize to [1, num / 2]<br>
time: O(log(num / 2))