import java.util.Scanner;

public class StrMatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Format INPUT<SPACE>PATTERN: abc a");
        while(scanner.hasNext()) {
            System.out.println(matches("", scanner.next()));
        }
    }

    public static boolean matches(String str, String pattern) {
        return false;
    }
}
