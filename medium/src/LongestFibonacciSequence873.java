public class LongestFibonacciSequence873 {
    public static void main(String[] args) {

        LongestFibonacciSequence873 obj = new LongestFibonacciSequence873();
    }

    public int lenLongestFibSubseq(int[] A) {
        int res = 2;
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                int a = A[i], b = A[j];
                int n = 2;
                for (int k = j+1; k < A.length && A[k] <= a+b; k++) {
                    if (A[k] == a+b) {
                        n += 1;
                        a = b;
                        b = A[k];
                    }
                }
                res = Math.max(res, n);
            }
        }
        return res==2 ? 0 : res;
    }
}
