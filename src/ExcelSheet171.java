public class ExcelSheet171 {
    public int titleToNumber(String s) {
        int p = 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = (int)s.charAt(i) - 'A' + 1;
            res = res*26 + v;
        }
        return res;
    }
}
