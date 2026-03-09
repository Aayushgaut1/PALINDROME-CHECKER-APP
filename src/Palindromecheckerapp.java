import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;
public class Palindromecheckerapp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello World - Modified v2");
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 12.0");
        System.out.println("System Initialized Successfully");
        System.out.print("Enter text: ");
        String input = scanner.nextLine();
        // =====================================
        // UC7 : Deque Based Palindrome Checker
        // =====================================
        System.out.println("\n----- UC7 : Deque Based Palindrome Checker -----");
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }
        boolean isPalindromeUC7 = true;
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindromeUC7 = false;
                break;
            }
        }
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindromeUC7);
        // =====================================
        // UC8 : LinkedList Based Palindrome
        // =====================================
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
        // =====================================
        // UC9 : Recursive Palindrome Checker
        // =====================================
        System.out.println("\n----- UC9 : Recursive Palindrome Checker -----");
        boolean isPalindromeUC9 = checkRecursive(input, 0, input.length() - 1);
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindromeUC9);
        // =====================================
        // UC10 : Case-Insensitive & Space Ignored
        // =====================================
        System.out.println("\n----- UC10 : Normalized Palindrome Validation -----");
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean isPalindromeUC10 = true;
        for (int i = 0; i < normalized.length() / 2; i++) {

            if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
                isPalindromeUC10 = false;
                break;
            }
        }
        System.out.println("Normalized : " + normalized);
        System.out.println("Is Palindrome? : " + isPalindromeUC10);
        // =====================================
        // UC11 : Object-Oriented Palindrome Service
        // =====================================
        System.out.println("\n----- UC11 : Object-Oriented Palindrome Service -----");
        PalindromeChecker checker = new PalindromeChecker();
        boolean resultUC11 = checker.checkPalindrome(input);
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + resultUC11);
        // =====================================
        // UC12 : Strategy Pattern
        // =====================================
        System.out.println("\n----- UC12 : Strategy Pattern Palindrome Checker -----");
        PalindromeStrategy strategy = new DequeStrategy();
        // You can switch algorithm here:
        // PalindromeStrategy strategy = new StackStrategy();
        PalindromeCheckerService service = new PalindromeCheckerService(strategy);
        boolean resultUC12 = service.check(input);
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + resultUC12);
        scanner.close();
    }
    // =====================================
    // UC9 Recursive Method
    // =====================================
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
// =====================================
// UC11 : PalindromeChecker Class
// =====================================
class PalindromeChecker {
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0;
        int end = normalized.length() - 1;
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
// =====================================
// UC12 : Strategy Interface
// =====================================
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}
// =====================================
// UC12 : Stack Strategy
// =====================================
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
// =====================================
// UC12 : Deque Strategy
// =====================================
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }
        return true;
    }
}
class PalindromeCheckerService {
    private PalindromeStrategy strategy;
    public PalindromeCheckerService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
    public boolean check(String input) {
        return strategy.isPalindrome(input);
    }
}