public class ReverseWordsInString151 {
    public static void main(String[] args) {

        ReverseWordsInString151 obj = new ReverseWordsInString151();
        System.out.println(obj.reverseWords("anbd kjsad  aKSJD"));
    }

    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = arr.length-1; i >= 0; i--) {
            res.append(arr[i]);
            if (i > 0) {
                res.append(' ');
            }
        }
        return res.toString();
    }

    public String reverseWordsWrong(String s) {
        String[] arr = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            res.append(reverse(arr[i]));
            if (i < arr.length-1) {
                res.append(' ');
            }
        }
        return res.toString();
    }

    public String reverse(String str) {
        StringBuilder reverse = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            reverse.append(str.charAt(i));
        }
        return reverse.toString();
    }
}
