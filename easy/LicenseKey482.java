public class LicenseKey482 {
    public static void main(String[] args) {

        LicenseKey482 obj = new LicenseKey482();
    }

    public String licenseKeyFormatting(String S, int K) {
        S = S.replace("-", "");
        int len = S.length();
        int mod = len % K;
        StringBuilder res = new StringBuilder(S.substring(0, mod));
        for (int i = mod; i < len; i += K) {
            if (i != 0) {
                res.append("-");
            }
            res.append(S.substring(i, i+K));
        }
        for (int i = 0; i < res.length();i++) {
            char ch = res.charAt(i);
            if (Character.isLowerCase(ch)) {
                res.setCharAt(i, Character.toUpperCase(ch));
            }
        }
        return res.toString();
    }
}
