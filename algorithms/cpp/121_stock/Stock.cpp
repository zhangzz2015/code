class Stock {
public:
	int maxProfit(vector<int>& prices) {
        int m = prices.size();
        vector<int> hold(m, 0), profit(m, 0);
        hold[0] = -prices[0];
        for (int i = 1; i < m; ++i) {
            hold[i] = max(hold[i - 1], -prices[i]);
            profit[i] = max(profit[i - 1], hold[i - 1] + prices[i]);
        }
        return profit[m - 1];
    }

	// space optimize
	int maxProfit_optimized(vector<int>& prices) {
        int hold = -prices[0], profit = 0;
        for (int i = 1; i < prices.size(); ++i) {
            hold = max(hold, -prices[i]);
            profit = max(profit, hold + prices[i]);
        }
        return profit;
    }
};
