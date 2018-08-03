import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber179 {
    public static void main(String[] args) {

        LargestNumber179 obj = new LargestNumber179();
    }

    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] + "";
        }
        /*
        Arrays.sort(arr, (s1, s2) -> {  int res = 0;
                                        int len1 = s1.length(), len2 = s2.length();
                                        int l = Math.min(len1, len2);
                                        for (int i = 0; res == 0 && i < l; i++) {
                                            res = s1.charAt(i) - s2.charAt(i);
                                        }
                                        if (res == 0 && len1 != len2) {
                                            String s = len1 > len2 ? s1 : s2;
                                            res = s.charAt(0) - s.charAt(l);
                                            res = len1 > len2 ? -1*res : res;
                                        }
                                      return res;
                                     });
        */
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                int res = 0;
                int len1 = s1.length(), len2 = s2.length();
                int l = Math.min(len1, len2);
                for (int i = 0; res == 0 && i < l; i++) {
                    res = s1.charAt(i) - s2.charAt(i);
                }
                if (res == 0 && len1 != len2) {
                    String s = len1 > len2 ? s1 : s2;
                    res = compare(s.substring(0, l), s.substring(l));
                    res = len1 > len2 ? -1*res : res;
                }
                return res;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length-1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        String s = sb.toString();
        if (s.charAt(0) == '0') {
            s = "0";
        }
        return s;
    }
}
