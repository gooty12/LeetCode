public class AddDigits258 {
    public int addDigits(int num) {
        int[] dp = new int[100]; //IntStream.range(0, 100).toArray();
        for (int i = 0; i < 100; i++) {
            int sum = sumDigits(i);
            dp[i] = sum <= 9 ? sum : dp[sum];
        }

        return dp[sumDigits(num)];
    }

    public int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}
