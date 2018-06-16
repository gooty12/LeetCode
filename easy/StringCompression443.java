public class StringCompression443 {
    public int compress(char[] chars) {
        int res = 0;
        for (int i = 0, index = 0; i < chars.length;) {
            int j = i;
            for (j = i; j < chars.length && chars[i]==chars[j]; j++);
            chars[index++] = chars[i];
            res += 1;
            if (j-i >= 2) {
                int[] arr = new int[4];
                int n = j-i, ind = 0;;
                while (n > 0) {
                    res += 1;
                    arr[ind++] = n%10;
                    n /= 10;
                }
                for (ind = ind-1; ind >= 0; ind--) {
                    chars[index++] = (char)('0' + arr[ind]);
                }
            }
            i = j;
        }
        return res;
    }
}
