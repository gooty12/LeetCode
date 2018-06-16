public class AddStrings414 {
    public String addStrings(String num1, String num2) {
        char[] arr = new char[Math.max(num1.length(), num2.length())+1];
        int carry = 0;
        int k = arr.length-1;
        for (int i = num1.length()-1, j = num2.length()-1; i>=0 || j>=0; i--, j--, k--) {
            int v1 = i >= 0 ? intValue(num1.charAt(i)) : 0;
            int v2 = j >= 0 ? intValue(num2.charAt(j)) : 0;
            int v = v1 + v2 + carry;
            arr[k] = (char)('0' + v%10);
            carry = v/10;
        }

        if (carry != 0) {
            arr[k--] = (char)('0'+carry);
        }
        return String.valueOf(arr, k+1, arr.length-k-1);
    }

    public int intValue(char s) {
        return s - '0';
    }
}
