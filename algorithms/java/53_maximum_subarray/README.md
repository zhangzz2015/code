## Solution
base case: m[0] = input[0]<br>
induction rule: m[i] represents [within the range from the beginning to the i-th element] the largest sum of the subarray(including the i-th element)<br>
m[i] = m[i - 1] + input[i]   if m[i - 1] >= 0<br>
input[i]  otherwise<br>
time: O(n)
space: O(n) -> can optimize to O(1) because we only need to record the sum before.