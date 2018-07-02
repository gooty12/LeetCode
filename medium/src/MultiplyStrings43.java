public class MultiplyStrings43 {
    public static void main(String[] args) {

        MultiplyStrings43 obj = new MultiplyStrings43();
    }

    public String multiply(String num1, String num2) {
        String ans = "";
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            ans = "0";
        }
        else {
            int[] res = new int[225];
            int lastIndex = 0;
            for (int i = num2.length()-1, st = 0; i >= 0; i--, st++) {
                int n2 = num2.charAt(i) - '0', ind = st, carry = 0;
                for (int j = num1.length()-1; j >= 0; j--, ind++) {
                    int n1 = num1.charAt(j) - '0';
                    int sum = carry + n1*n2 + res[ind];
                    res[ind] = sum % 10;
                    carry = sum / 10;
                }
                if (carry > 0) {
                    res[ind++] = carry;
                }
                lastIndex = ind;
            }

            for (int i = lastIndex-1; i >= 0; i--) {
                ans += res[i];
            }
        }

        return ans;
    }
}
