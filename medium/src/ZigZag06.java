public class ZigZag06 {
    public static void main(String[] args) {

        ZigZag06 obj = new ZigZag06();
    }

    public String convert(String s, int numRows) {
        StringBuilder[] res = new StringBuilder[numRows+1];
        for (int i = 0; i < res.length; i++) {
            res[i] = new StringBuilder();
        }
        for (int i = 0, n = 1; numRows != 0 && i < s.length(); i++) {
            int indx;
            if (n > 0) {
                indx = n;
                n = n == numRows ? (numRows<=2 ? 1 :-1) : n +1;
            }
            else {
                indx = numRows+n;
                n = indx == 2 ? 1 : n-1;
            }
            res[indx].append(s.charAt(i));
        }
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i <= numRows; i++) {
            s2.append(res[i]);
        }
        return s2.toString();
    }

    public String convert2(String s, int numRows) {
        StringBuilder[] res = new StringBuilder[numRows+1];
        for (int i = 0; i < res.length; i++) {
            res[i] = new StringBuilder();
        }
        boolean up = true;
        for (int i = 0, n = 1; numRows != 0 && i < s.length(); i++) {
            res[n].append(s.charAt(i));
            if (up) {
                up = n==numRows ? false : true;
                n = n==numRows ? Math.max(1, n-1) : n+1;
            }
            else {
                up = n==1 ? true : false;
                n = n==1 ? Math.min(numRows, n+1) : n-1;
            }
        }
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i <= numRows; i++) {
            s2.append(res[i]);
        }
        return s2.toString();
    }
}
