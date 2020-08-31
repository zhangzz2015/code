## dp

    1. dp[i][target] means using coins[0, 1,..., i] to conduct target, the min # of coins we need.
    2. induction rule:
        case 1: we don't pick coins[i - 1] -> dp[i - 1][target]
        case 2: we pick coins[i - 1] -> dp[i][target - coins[i - 1]] + 1
        dp[i][target] = min(case 1, case 2)
    3. result:
        dp[i][target]
         0 1 2 3 ... k  target
       0 0
    1  1 0       y
    2  2 0   y   X
    5  3 0
    coins
    4. base case:
        dp[i][0] = 0, the min # of coins to conduct target 0 is 0
    5. fill in order
        top -> bottom, left -> right
    time: O(n^2)
    space: O(n^2) -> optimize to O(n)
