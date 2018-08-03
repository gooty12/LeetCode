import jdk.internal.util.xml.impl.Pair;

import java.util.Arrays;

public class AdvantageShuffle870 {
    public static void main(String[] args) {

        AdvantageShuffle870 obj = new AdvantageShuffle870();
    }

    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        Pair2[] pairs = new Pair2[B.length];
        for (int i = 0; i < B.length; i++) {
            pairs[i] = new Pair2(B[i], i);
        }
        Arrays.sort(pairs, (a, b) -> a.val-b.val);

        int[] res = new int[A.length];
        Arrays.fill(res, -1);
        for (int i = 0, j = 0; i < pairs.length && j < A.length; i++) {
            Pair2 p = pairs[i];
            for (; j < A.length && A[j] <= p.val; j++);
            if (j < A.length) {
                res[p.indx] = A[j];
                A[j] = -1;
                j++;
            }
        }

        for (int i = 0, j = 0; i < res.length && j < A.length; i++) {
            if (res[i] == -1) {
                for (; j < A.length && A[j]==-1; j++);
                if (j < A.length) {
                    res[i] = A[j];
                    A[j] = -1;
                    j++;
                }
            }
        }

        return res;
    }
}

class Pair2 {
    int val;
    int indx;
    public Pair2(int val, int indx) {
        this.val = val;
        this.indx = indx;
    }
}

