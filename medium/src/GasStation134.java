public class GasStation134 {
    public static void main(String[] args) {

        GasStation134 obj = new GasStation134();
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diffs = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            diffs[i] = gas[i] - cost[i];
        }

        int res = -1;
        for (int i = 0; res==-1 && i < diffs.length; i++) {
            if (diffs[i]<0) {
                continue;
            }
            int net = 0;
            int count = 1;
            for (int j = i; net >= 0 && count <= diffs.length; j = (j+1) % diffs.length) {
                net += diffs[j];
                count += 1;
            }
            if (net >= 0) {
                res = i;
            }
        }

        return res;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int total = 0, tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i+1;
                total += tank;
                tank = 0;
            }
        }

        return total+tank<0 ? -1 : start;
    }
}
