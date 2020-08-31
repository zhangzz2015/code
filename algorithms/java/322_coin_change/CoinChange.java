public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (dp[i - 1][j] != -1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                }
                if (j >= coins[i - 1] && dp[i][j - coins[i - 1]] != -1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i - 1]] + 1);
                }
                dp[i][j] = dp[i][j] == Integer.MAX_VALUE ? -1 : dp[i][j];
            }
        }
        return dp[coins.length][amount];
    }

    // space optimize
    public int coinChange1(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] == -1) {
                    continue;
                }
                if (dp[j] == -1 || dp[j] > dp[j - coins[i]] + 1) {
                    dp[j] = dp[j - coins[i]] + 1;
                }
            }
        }
        return dp[amount];
    }
}