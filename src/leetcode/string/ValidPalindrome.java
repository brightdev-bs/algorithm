package leetcode.string;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isAlphabetic(c) || Character.isDigit(c)) sb.append(c);
        }

        String res = sb.toString();
        int n = res.length();
        for(int i = 0; i < n; i++) {
            if(res.charAt(i) != res.charAt(n - 1 - i)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome m = new ValidPalindrome();
        System.out.println(m.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(m.isPalindrome("race a car"));
        System.out.println(m.isPalindrome("0P"));
    }
}
