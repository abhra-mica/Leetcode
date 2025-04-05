package oneD_dp;

import java.util.Arrays;

public class L322_CoinChange {
	public static void main(String[] args) {
		int[] coins = {2};
		int amount = 3;
		int result = coinChange(coins, amount);
		System.out.println("Minimum Coins required= " + result);
	}

	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		Arrays.sort(coins);

		for (int val = 1; val <= amount; val++) {
			for (int coin : coins) {
				if (coin <= val) {
					int restVal = val - coin;
					dp[val] = Math.min(dp[val], dp[restVal] + 1);
				}
			}
		}

		return dp[amount] > amount ? -1 : dp[amount];
	}
}
