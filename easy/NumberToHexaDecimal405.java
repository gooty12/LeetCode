public class NumberToHexaDecimal405 {
    public String toHex(int num) {
        String res = "0";
        if (num != 0) {
            boolean isNegative = num < 0;
            num = Math.abs(num);
            String binary = Integer.toBinaryString(num);
            String s = "";
            for (int i = 0; i < 32-binary.length(); i++) {
                s += "0";
            }
            binary = s + binary;
            char[] arr = binary.toCharArray();
            if (isNegative) {
                int lastZero = -1;
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = arr[i]=='1' ? '0' : '1';
                    lastZero = arr[i]=='0' ? i : lastZero;
                }
                arr[lastZero] = '1';
                for (int i = lastZero+1; i < arr.length; i++) {
                    arr[i] = '0';
                }
            }
            res = arr.length%4==0 ? "" : hexValue(arr, 0, arr.length%4);
            for (int i = arr.length%4; i < arr.length; i+=4) {
                res += hexValue(arr, i, 4);
            }
            res = res.replaceFirst("^0+", "");
        }
        return res;
    }

    public String hexValue(char[] arr, int start, int len) {
        int res = 0;
        for (int i = start; i < start + len; i++) {
            int v = arr[i] == '0' ? 0 : 1;
            res = res * 2 + v;
        }
        String ans = "";
        if (res < 10) {
            ans += res;
        }
        else {
            ans = ans + (char)('a'+res-10);
        }
        return ans;
    }
}
