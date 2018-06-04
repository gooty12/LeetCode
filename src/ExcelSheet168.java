public class ExcelSheet168 {
    public String convertToTitle(int n) {
        String s = "";
        while (n > 0) {
            int mod = (n%26 == 0 ? 25 : n%26 - 1);
            char ch = (char)('A' + mod);
            s = ch + s;
            n = n%26 == 0 ? n/26 - 1 : n/26;
        }
        return s;
    }
}
