## Solution
* **a == 0**:
    * b > 0: increase
    * else: decrease or all equal to c
* **a > 0**:
    fill the result from index 0 to length - 1 with: find the largest smaller or equal than - b / (2a), and 谁小移谁
* **a < 0**:
    fill the result from index length - 1 to 0 with: find the largest smaller or equal than - b / (2a), and 谁小移谁

Time: O(logn + n)<br>
Space: O(1) 
