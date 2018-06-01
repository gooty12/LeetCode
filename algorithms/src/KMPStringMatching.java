public class KMPStringMatching {
    public static int matchSting(String haystack, String needle) {

        int res = 0;

        // pre process
        int[] preprocess = new int[needle.length()];
        preprocess[0] = 0;
        int j = 0;  // no.of characters matched till now
        for (int i = 1; i < needle.length(); i++) {
            if (needle.charAt(i) == needle.charAt(j)) {
                preprocess[i] = j + 1;
                j += 1;
            } else {
                while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                    j = preprocess[j - 1];
                }
                if (needle.charAt(i) == needle.charAt(j)) {
                    preprocess[i] = j + 1;
                    j += 1;
                } else {
                    preprocess[i] = 0;
                    j = 0;
                }
            }
        }

        //search
        j = 0;
        for (int i = 0; i < haystack.length(); i++) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                j += 1;
            } else {
                while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                    j = preprocess[j - 1];
                }
                if (haystack.charAt(i) == needle.charAt(j)) {
                    j += 1;
                } else {
                    j = 0;
                }
            }

            if (j == needle.length()) {
                res = i - (needle.length() - 1);
                break;
            }
        }

            return res;
    }
}
