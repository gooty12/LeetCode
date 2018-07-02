public class PermutationSequence60 {
    public static void main(String[] args) {

        PermutationSequence60 obj = new PermutationSequence60();
        obj.getPermutation(3, 3);
    }

    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n+1];
        used[0] = true;
        int[] fact = new int[10];
        fact[0] = fact[1] = 1;
        for (int i = 2; i <= 9; i++) {
            fact[i] = fact[i-1] * i;
        }
        String res = "";
        for (int i = n; i > 0; i--) {
            int p = k / fact[i-1];
            if (k % fact[i-1] == 0) {
                p -= 1;
            }
            int j = 0;
            for (int k1 = 0; j <= n && k1 < p+1; j++) {
                k1 = !used[j]? k1+1 : k1;
            }
            used[j-1] = true;
            res += j-1;
            k -= p*fact[i-1];
        }
        return res;
    }
}
