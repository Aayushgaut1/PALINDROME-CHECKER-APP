import java.util.Scanner;

public class Palindromecheckerapp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 3.0");
        System.out.println("System Initialized Successfully");
        System.out.print("Enter text: ");

        String input = scanner.nextLine();
        String reversed = "";

        // Reverse the string using loop
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        // Compare original and reversed string
        boolean isPalindrome = input.equals(reversed);

        System.out.println("Original String : " + input);
        System.out.println("Reversed String : " + reversed);
        System.out.println("Is it a Palindrome? : " + isPalindrome);

        scanner.close();
    }
}