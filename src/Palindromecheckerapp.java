import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class Palindromecheckerapp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello World - Modified v2");
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 10.0");
        System.out.println("System Initialized Successfully");

        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        // ===============================
        // UC7 : Deque Based Palindrome Checker
        // ===============================
        System.out.println("\n----- UC7 : Deque Based Palindrome Checker -----");

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {

            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);


        // ===============================
        // UC8 : LinkedList Based Palindrome Checker
        // ===============================
        System.out.println("\n----- UC8 : LinkedList Based Palindrome Checker -----");

        LinkedList<Character> list = new LinkedList<>();

        for (char c : input.toCharArray()) {
            list.add(c);
        }

        boolean isPalindromeUC8 = true;

        while (list.size() > 1) {

            char first = list.removeFirst();
            char last = list.removeLast();

            if (first != last) {
                isPalindromeUC8 = false;
                break;
            }
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindromeUC8);


        // ===============================
        // UC9 : Recursive Palindrome Checker
        // ===============================
        System.out.println("\n----- UC9 : Recursive Palindrome Checker -----");

        boolean isPalindromeUC9 = checkRecursive(input, 0, input.length() - 1);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindromeUC9);


        // ===============================
        // UC10 : Case-Insensitive & Space-Ignored Palindrome
        // ===============================
        System.out.println("\n----- UC10 : Normalized Palindrome Validation -----");

        // Normalize string
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean isPalindromeUC10 = true;

        for (int i = 0; i < normalized.length() / 2; i++) {

            if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
                isPalindromeUC10 = false;
                break;
            }
        }

        System.out.println("Input : " + input);
        System.out.println("Normalized : " + normalized);
        System.out.println("Is Palindrome? : " + isPalindromeUC10);

        scanner.close();
    }


    // ===============================
    // UC9 Recursive Function
    // ===============================
    private static boolean checkRecursive(String s, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }

        return checkRecursive(s, start + 1, end - 1);
    }
}