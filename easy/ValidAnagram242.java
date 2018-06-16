import java.util.Arrays;

public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        Arrays.fill(arr1, 0);
        Arrays.fill(arr2, 0);
        int[] c1 = new int[s.length()];
        int[] c2 = new int[t.length()];
        for (int i = 0; i < s.length(); i++) {
            c1[i] = (int)s.charAt(i) - 'a';
        }
        for (int i = 0; i < t.length(); i++) {
            c2[i] = (int)t.charAt(i) - 'a';
        }
        Arrays.stream(c1).forEach(i -> arr1[i] += 1);
        Arrays.stream(c2).forEach(i -> arr2[i] += 1);
        return Arrays.equals(arr1, arr2);
    }
}
