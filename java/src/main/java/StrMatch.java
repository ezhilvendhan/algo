import java.util.Scanner;

public class StrMatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Format INPUT<SPACE>PATTERN: abc a");
        String[] input;
        while(scanner.hasNext()) {
            input = scanner.nextLine().split("\\s+");
            if(input.length == 2) {
                System.out.println(matches(input[0], input[1]));
            }
        }
    }

//     isMatch(“aa”,”a”) → false
//     isMatch(“aa”,”aa”) → true
//     isMatch(“aaa”,”aa”) → false
//     isMatch(“aa”, “a*”) → true
//     isMatch(“aa”, “*”) → true
//     isMatch(“ab”, “*”) → true
//     isMatch(“ab”, “*”) → true
//     isMatch(“b*a”, “a”) → true
//     isMatch(“a*a”, “a”) → true
//     isMatch(“aab”, “c*a*b”) → true
    public static boolean matches(String str, String pattern) {
        return matches(str, pattern, str.length()-1, pattern.length()-1);
    }
    public static boolean matches(String str, String pattern,int strIdx, int patternIdx) {
        if("*".equals(pattern)) {
            return true;
        }
        if(strIdx < 0 && patternIdx < 0) {
            return true;
        } else if(strIdx < 0) {
            while(patternIdx >= 0) {
                if(pattern.charAt(patternIdx) == '*') {
                    patternIdx = patternIdx-2;
                    if(patternIdx < 0) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        } else if(patternIdx < 0){
            while(strIdx >= 0) {
                if(str.charAt(strIdx) == '*') {
                    strIdx = strIdx-2;
                    if(strIdx < 0) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        } else {
            if(pattern.charAt(patternIdx) == str.charAt(strIdx)) {
                return matches(str, pattern, --strIdx, --patternIdx);
            } else {
                if(pattern.charAt(patternIdx) == '*') {
                    --patternIdx;
                    while(strIdx >=0 && pattern.charAt(patternIdx) == str.charAt(strIdx)) {
                        strIdx--;
                    }
                    return matches(str, pattern, --strIdx, --patternIdx);
                }
                if(str.charAt(patternIdx) == '*') {
                    strIdx = strIdx - 2;
                    return matches(str, pattern, strIdx, --patternIdx);
                }
            }
        }
        return false;
    }
}
