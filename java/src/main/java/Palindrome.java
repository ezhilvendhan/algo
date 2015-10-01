public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("rotor"));
    }

    private static boolean isPalindrome(String str) {
        if(null == str || str.length() == 0) {
            return false;
        }
        if(str.length() == 1) {
            return true;
        } else {
            if(str.charAt(0) == str.charAt(str.length() - 1)) {
                return isPalindrome(str.substring(1, str.length()-1));
            } else {
                return false;
            }
        }
    }
}
