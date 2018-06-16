public class RansomNote383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[256];
        for (int i = 0; i < magazine.length(); i++) {
            int ind = magazine.charAt(i);
            arr[ind] += 1;
        }
        boolean res = true;
        for (int i = 0; res && i < ransomNote.length(); i++) {
            int ind = ransomNote.charAt(i);
            arr[ind] -= 1;
            res = arr[ind] >= 0;
        }
        return res;
    }
}
