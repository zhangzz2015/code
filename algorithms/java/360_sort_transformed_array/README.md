## Solution
* **a == 0**:
    * b > 0: increase
    * else: decrease or all equal to c
* **a > 0**:
    fill the result from index 0 and index length - 1, and 谁小移谁
* **a < 0**:
    fill the result from index 0 and index length - 1, and 谁小移谁

Time: O(n)<br>
Space: O(1) 
