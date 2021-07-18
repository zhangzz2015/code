## dp
We need to maintain two kinds of information, because there are two options that we can do each day, which is buy and sell.

	1. hold[i] means when the max amount of stock we can hold at day i the money left. profit[i] means the max profit until day i.
	2. induction rule
	    hold[i] = max(hold[i - 1], -prices[i])
	    profit[i] = max(profit[i - 1], hold[i - 1] + prices[i])
	3. filling order
	    left -> right
	4. base case
	    hold[0] = -prices[0], profit[0] = 0
	5. result
	    profit[n - 1]
	6. optimize
	    space can optimize from O(n) -> O(1)

time: O(n)<br>
space: O(n) -> O(1)
