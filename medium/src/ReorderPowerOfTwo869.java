public class ReorderPowerOfTwo869 {
    public static void main(String[] args) {

        ReorderPowerOfTwo869 obj = new ReorderPowerOfTwo869();
    }

    public boolean reorderedPowerOf2(int N) {
        char[] arr = (N+"").toCharArray();
        return recurse(arr, new boolean[arr.length], 0, 0);
    }

    public boolean recurse(char[] arr, boolean[] used, long val, int indx) {
        boolean res = false;
        if (indx >= arr.length) {
            res = Long.bitCount(val) == 1;
        }
        else {
            for (int i = 0; i<arr.length && !res; i++) {
                if (!used[i]) {
                    if (!(indx==0 && arr[i]=='0')) {
                        used[i] = true;
                        res = recurse(arr, used, val*10+arr[i]-'0', indx+1);
                        used[i] = false;
                    }
                }
            }
        }
        return res;
    }
}
