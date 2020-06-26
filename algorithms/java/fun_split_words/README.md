## Given a String and a dictionary, find the minimum number of partitions to cut the String. Each partition is in the dictionary.<br>e.g.<br>“catsandog”, dict = [“cat”, “cats”, “and”, “san”, “dog”, “o”, “g”]<br>return 3, [cat   san dog]

if we cannot find a valid partition we can return 0<br>
I think we can use dynamic programming to solve this problem.<br>
base case: dp[0] = 0;<br>
induction rule: dp[i] represents the minimum number of partitions to cut of substring from index first element to the (i - 1)-th element.<br>
dp[i] = mid{all the j where 0 <= j < i, dp[j] + 1} if substring(j + 1, i) is in the dictionary and dp[j] != 0<br>
dp[i] = 1 if substring from index 0 to index i -1 is in the dictionary<br>
time: O(n^2)<br>
space: O(n)

## Follow Up: return how you partition the string.
We can store a previous index