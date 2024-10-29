public class L121_BestTimetoBuyandSellStock {
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		int result = maxProfit(prices);
		System.out.println("Max Profit= " + result);

	}

	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		int minPrice = prices[0];

		for (int price : prices) {
			minPrice = Math.min(minPrice, price);
			maxProfit = Math.max(maxProfit, price - minPrice);
		}
		return maxProfit;
	}
}
