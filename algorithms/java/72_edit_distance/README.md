## dp

    1. definition: dp[i][j] = edit distance of first i characters of s1 and first j characters of s2 (using off by one trick)
    2. induction rule:
        if s1[i - 1] == s2[j - 1], dp[i - 1][j - 1]
        else min(
            replace -> dp[i - 1][j - 1] + 1
            insert s1[i]/ delete s2[j - 1] -> dp[i][j - 1] + 1
            delete s1[i - 1]/ insert s2[j] -> do[i - 1][j] + 1
            )
    3. result: dp[m][n]

               a  b  b  c s2
            0  1  2  3  4 
           -----------------
        0 | 0  1  2  3  4
      c 1 | 1
      a 2 | 2
      b 3 | 3     y  y
      d 4 | 4     y  X
      c 5 | 5
    4. base case:
        dp[0][j] = j, dp[i][0] = i
    5. fill in order
        top -> bottom, left -> right
    
    time: O(n^2)
    space: O(n^2) -> optimize to O(n)