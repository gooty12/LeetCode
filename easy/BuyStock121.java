public class BuyStock121 {
        public int maxProfit(int[] prices) {

            int res = 0;
            if (prices.length != 0) {
                int[] maxPrice = new int[prices.length];
                maxPrice[prices.length-1] = prices[prices.length-1];
                for (int i = prices.length-2; i >= 0; i--) {
                    maxPrice[i] = Math.max(prices[i], maxPrice[i+1]);
                }
                for (int i = 0; i < prices.length-1; i++) {
                    res = Math.max(res, maxPrice[i+1]-prices[i]);
                }
            }

            return res;
        }

        // O(1) space.
        public int maxProfit2(int[] prices) {
            int res = 0;
            if (prices.length != 0) {
                int buy = prices[0];
                for (int p : prices) {
                    if (p > buy) {
                        res = Math.max(res, p-buy);
                    }
                    else {
                        buy = p;
                    }
                }
            }
            return res;
        }
    }

