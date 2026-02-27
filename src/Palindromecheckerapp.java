import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Palindromecheckerapp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 7.0");
        System.out.println("System Initialized Successfully");
        System.out.print("Enter text: ");

        String input = scanner.nextLine();

        // Create Deque (Double Ended Queue)
        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindrome = true;

        // Compare front and rear elements
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

        scanner.close();
    }
}