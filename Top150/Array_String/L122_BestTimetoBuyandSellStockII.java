package array_string;

//Will solve this problem with the intuition, after buying when the next value is greater we sell it. A greedy approach 
//so we start from 1st index and keep checking if ith value is greater than the i-1 value we sell it and the profit and
// into max profit

public class L122_BestTimetoBuyandSellStockII {
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		int result = maxProfit(prices);
		System.out.println("Max profit= " + result);
	}

	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				maxProfit += prices[i] - prices[i - 1];
			}
		}
		return maxProfit;
	}
}
