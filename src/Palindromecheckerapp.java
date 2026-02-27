import java.util.Scanner;

public class Palindromecheckerapp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 4.0");
        System.out.println("System Initialized Successfully");
        System.out.print("Enter text: ");

        String input = scanner.nextLine();

        // Convert string to character array
        char[] chars = input.toCharArray();

        // Two-pointer initialization
        int start = 0;
        int end = chars.length - 1;

        boolean isPalindrome = true;

        // Compare characters using two-pointer technique
        while (start < end) {

            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);

        scanner.close();
    }
}