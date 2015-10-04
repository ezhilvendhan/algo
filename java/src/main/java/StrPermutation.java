import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StrPermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Format: ABC");
        while(scanner.hasNext()) {
            System.out.println(permutation("", scanner.next()));
        }
    }

    public static Set<String> permutation(String prefix, String str) {
        Set<String> result = new HashSet<>();
        if(null == str || str.length() == 0) {
            result.add(prefix);
            return result;
        }
        for(int idx=0; idx < str.length(); idx++) {
            result.addAll(permutation(prefix+str.charAt(idx),
                    str.substring(0, idx)+str.substring(idx+1)));
        }
        return result;
    }
}
