public class FirstUniqueCharacter387 {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int indx = s.charAt(i);
            indx -= 97;
            count[indx] += 1;
        }
        int res = -1;
        for (int i = 0; res==-1 && i < s.length(); i++) {
            int indx = s.charAt(i);
            indx -= 97;
            res = count[indx]==1? i : -1;
        }
        return res;
    }
}
