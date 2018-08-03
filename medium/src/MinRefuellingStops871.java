import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinRefuellingStops871 {
    public static void main(String[] args) {

        MinRefuellingStops871 obj = new MinRefuellingStops871();
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int fuel = startFuel;
        int i = 0;
        while(fuel < target) {
            while (i < stations.length && fuel >= stations[i][0]) {
                pq.offer(stations[i][1]);
                i++;
            }
            if (pq.isEmpty()) {
                break;
            }
            fuel += pq.poll();
            n += 1;
        }
        return fuel >= target ? n : -1;
    }

    public int minRefuelStops2(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] dp = new long[n+1];
        dp[0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int t = i; t >= 0 && dp[t] >= stations[i][0]; t--) {
                dp[t+1] = Math.max(dp[t+1], dp[t] + stations[i][1]);
            }
        }
        int res  = -1;
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                res = i;
                break;
            }
        }
        return res;
    }
}
