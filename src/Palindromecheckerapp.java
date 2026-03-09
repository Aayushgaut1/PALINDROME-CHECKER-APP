import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class Palindromecheckerapp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello World - Modified v2");
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 8.0");
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

        scanner.close();
    }
}