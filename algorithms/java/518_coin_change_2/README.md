## dp

    1. dp[i][target] = using coins[0, 1, ..., i] to conduct target, how many ways.
    2. induction rule:
        case 1: we don't pick coins[i - 1] -> dp[i - 1][target]
        case 2: we pick coins[i - 1] -> dp[i][target - coins[i - 1]]
        dp[i][target] = case 1 + case 2
    3. result:
        dp[n][target]
            0 1 2 3 ... k target
          0 1
        1 1 1        y
        3 2 1   y    X
        5 3 1
    4. base case:
        dp[n][0] = 1
    5. fill in order:
        top -> bottom, left -> right
    time: O(n^2)
    space: O(n^2) -> O(n)