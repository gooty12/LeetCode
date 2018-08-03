import java.util.regex.Pattern;

public class CompareVersion165 {
    public static void main(String[] args) {

        CompareVersion165 obj = new CompareVersion165();
    }

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split(Pattern.quote("."));
        String[] arr2 = version2.split(Pattern.quote("."));
        int res = 0;
        for (int i = 0; res==0 && (i < arr1.length || i < arr2.length); i++) {
            long n1 = i < arr1.length ? Long.parseLong(arr1[i]) : 0;
            long n2 = i < arr2.length ? Long.valueOf(arr2[i]) : 0;
            res = (int)(n1 - n2);
        }
        return res  != 0 ? res/(int)Math.abs(res) : res;
    }
}
